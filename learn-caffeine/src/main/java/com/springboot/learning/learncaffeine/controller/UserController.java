package com.springboot.learning.learncaffeine.controller;

import com.springboot.learning.learncaffeine.entity.User;
import com.springboot.learning.learncaffeine.response.Response;
import com.springboot.learning.learncaffeine.service.UserCaffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    UserCaffeine userCaffeine;

    @Autowired
    public void setUserCaffeine(UserCaffeine userCaffeine) {
        this.userCaffeine = userCaffeine;
    }

    @GetMapping("/get")
    public Response<User> getUser(@RequestParam("userId") int userId) {
        return Response.OK(userCaffeine.getUser(userId));
    }

    @PostMapping("/put")
    public Response<Boolean> putUser(@RequestBody User user) {
        userCaffeine.addUser(user);
        return Response.OK(true);
    }

    @GetMapping("/get-users")
    public Response<List<User>> getUsers(@RequestParam("userIds") List<Integer> userIds) {
        return Response.OK(new ArrayList<>(userCaffeine.getAllUser(userIds).values()));
    }
}
