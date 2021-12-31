package com.springboot.learning.learnspringsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/get")
    public ResponseEntity<String> getUser() {
        return new ResponseEntity<>("get_user", HttpStatus.OK);
    }

    @PostMapping("/get")
    public ResponseEntity<String> updateUser() {
        return new ResponseEntity<>("update_user", HttpStatus.OK);
    }

    @DeleteMapping("/get")
    public ResponseEntity<String> addUser() {
        return new ResponseEntity<>("add_user", HttpStatus.OK);
    }
}
