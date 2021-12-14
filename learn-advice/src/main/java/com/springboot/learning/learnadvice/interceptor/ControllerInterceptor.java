package com.springboot.learning.learnadvice.interceptor;

import com.springboot.learning.learnadvice.exceptions.ControllerException;
import com.springboot.learning.learnadvice.exceptions.ControllerExceptionBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author: zjhan
 * @Date: 2021/4/22 15:52
 * @Description: 当controller遇到异常时，捕捉响应异常，并进行处理
 **/
@Order(3)
@ControllerAdvice(basePackages = {"com.springboot.learning.learnadvice.controller.web", "com.springboot.learning.learnadvice.controller.api"})
public class ControllerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);

    /**
     * 使用@ExceptionHandler全局处理异常
     * @param request
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(ControllerExceptionBase.class)
    public ResponseEntity controllerExceptionBaseHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        logger.info("ControllerAdvice run");
        logger.error(e.getMessage(), e);
        return new ResponseEntity(5000, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity controllerExceptionHandler(Exception e) {
        logger.info("ControllerAdvice run");
        logger.error(e.getMessage(), e);
        return new ResponseEntity(50001, HttpStatus.EXPECTATION_FAILED);
    }
}
