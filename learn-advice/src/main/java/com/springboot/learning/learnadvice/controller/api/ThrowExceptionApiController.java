package com.springboot.learning.learnadvice.controller.api;


import com.springboot.learning.learnadvice.exceptions.ControllerException;
import com.springboot.learning.learnadvice.exceptions.ControllerExceptionBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zjhan
 * @Date: 2021/4/22 15:48
 * @Description:
 **/
@RestController
@RequestMapping("/api")
public class ThrowExceptionApiController {
    @GetMapping("/exceptionBase")
    public ResponseEntity throwExceptionBase() throws ControllerExceptionBase {
        throw new ControllerExceptionBase("api throw base exception test");
    }

    @GetMapping("/exception")
    public ResponseEntity throwException() throws ControllerException {
        throw new ControllerException("api throw exception test");
    }

}
