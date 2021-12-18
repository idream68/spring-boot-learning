package com.springboot.learning.learnswagger.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("响应模板")
@Data
public class Response<T> {
    @ApiModelProperty("响应码")
    int code;
    @ApiModelProperty("响应数据")
    T data;
    @ApiModelProperty("报错信息")
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
