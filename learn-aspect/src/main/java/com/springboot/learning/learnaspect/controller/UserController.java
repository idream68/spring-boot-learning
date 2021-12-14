package com.springboot.learning.learnaspect.controller;

import com.springboot.learning.learnaspect.annotation.WebLog;
import com.springboot.learning.learnaspect.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aspects")
public class UserController {
    @GetMapping("/getUser")
    public User getUser(@RequestParam("name") String name,
                        @RequestParam("age") int age) {
        return new User(name, age);
    }

    @WebLog("del")
    @PostMapping("/delUser")
    public boolean del(@RequestParam("name") String name) {
        new User().setName(name);
        return true;
    }
}
