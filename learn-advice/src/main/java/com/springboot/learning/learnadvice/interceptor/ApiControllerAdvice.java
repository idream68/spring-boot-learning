package com.springboot.learning.learnadvice.interceptor;

import com.springboot.learning.learnadvice.exceptions.ControllerException;
import com.springboot.learning.learnadvice.exceptions.ControllerExceptionBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Editor zjhan
 * @Date 2021/12/14 20:29
 * @Description TODO
 */
@Order(2)
@RestControllerAdvice(basePackages = "com.springboot.learning.learnadvice.controller.api")
public class ApiControllerAdvice {
    Logger logger = LoggerFactory.getLogger(ApiControllerAdvice.class);

    /**
     * 使用@ExceptionHandler全局处理异常
     * @param request
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(ControllerExceptionBase.class)
    public ResponseEntity controllerExceptionBaseHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        logger.info("ApiControllerAdvice run");
        logger.error(e.getMessage(), e);
        return new ResponseEntity(5000, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity controllerExceptionHandler(Exception e) {
        logger.info("ApiControllerAdvice run");
        logger.error(e.getMessage(), e);
        return new ResponseEntity(50001, HttpStatus.EXPECTATION_FAILED);
    }
}
