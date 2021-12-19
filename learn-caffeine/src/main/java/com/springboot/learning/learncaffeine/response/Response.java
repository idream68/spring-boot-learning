package com.springboot.learning.learncaffeine.response;

import lombok.Data;

@Data
public class Response<T> {
    int code;
    T data;
    String errMessage;

    public Response(int code, T data, String errMessage) {
        this.code = code;
        this.data = data;
        this.errMessage = errMessage;
    }

    public static <T> Response<T> OK(T data, String errMessage) {
        return new Response<>(200, data, errMessage);
    }

    public static <T> Response<T> OK(T data) {
        return new Response<>(200, data, "OK");
    }

    public static <T> Response<T> ERR(T data, String errMessage) {
        return new Response<>(500, data, errMessage);
    }
}
