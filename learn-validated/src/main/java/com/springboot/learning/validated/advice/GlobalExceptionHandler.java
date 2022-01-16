package com.springboot.learning.validated.advice;

import com.springboot.learning.validated.entity.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error(exception.getMessage(), exception);
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        //多个错误，取第一个
        FieldError error = fieldErrors.get(0);
        String msg = error.getDefaultMessage();
        return Response.builder().code(500).message(msg).build();
    }
}
