package com.springboot.learning.learnswagger2.controller;

import com.springboot.learning.learnswagger2.entity.User;
import com.springboot.learning.learnswagger2.request.UserRequest;
import com.springboot.learning.learnswagger2.response.Response;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("用户管理")
public class UserController {
    @ApiOperation("更新用户")
    @PostMapping("/update")
    public Response<User> updateUser(@RequestBody UserRequest request) {
        User user = User.builder().name(request.getName()).build();
        return Response.OK(user);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/get")
    public Response<User> getUser(@ApiParam(value = "用户名称", required = true) @RequestParam("name") String name) {
        User user = User.builder().name(name).build();
        return Response.OK(user);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", dataType = "String", required = true),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "int", required = true)
    })
    @ApiOperation("获取用户信息")
    @GetMapping("/getByAll")
    public Response<User> getUser(@RequestParam("name") String name, @RequestParam("age") int age) {
        User user = User.builder().name(name).age(age).build();
        return Response.OK(user);
    }
}
