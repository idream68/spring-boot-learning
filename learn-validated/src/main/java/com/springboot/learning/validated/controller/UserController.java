package com.springboot.learning.validated.controller;

import com.springboot.learning.validated.entity.PasswordRequest;
import com.springboot.learning.validated.entity.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 没有根据条件判断
     * @param request
     * @return
     */
    @PostMapping("/add1")
    public String addUser(@RequestBody UserRequest request) {
        System.out.println(request);
        return "user";
    }

    /**
     * 根据条件判断
     * @param request
     * @return
     */
    @PostMapping("/add2")
    public String addUser2(@Valid @RequestBody UserRequest request) {
        System.out.println(request);
        return "user1";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody PasswordRequest request) {
        System.out.println(request);
        return "login";
    }
}
