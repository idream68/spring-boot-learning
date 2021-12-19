package com.springboot.learning.learnwebfile.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    int code;
    T data;
    String errMessage;

    public static  <T> Response<T> OK(T data, String errMessage) {
        return new Response<>(200, data, errMessage);
    }

    public static <T> Response<T> OK(T data) {
        return new Response<>(200, data, "OK");
    }

    public static <T> Response<T> ERR(T data, String errMessage) {
        return new Response<>(500, data, errMessage);
    }

    public static <T> Response<T> ERR(String errMessage) {
        return new Response<>(500, null, errMessage);
    }
}
