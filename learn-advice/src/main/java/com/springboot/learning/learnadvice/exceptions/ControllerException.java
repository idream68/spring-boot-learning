package com.springboot.learning.learnadvice.exceptions;

/**
 * @Author: zjhan
 * @Date: 2021/4/22 16:15
 * @Description:
 **/
public class ControllerException extends Throwable {
    private int code;
    public ControllerException(String message) {
        super(message);
        this.code = 500;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
