package com.springboot.learning.learnspringsecurity.request;

import lombok.Data;

@Data
public class LoginRequest {
    /**
     * 用户名或邮箱或手机号
     */
    private String usernameOrEmailOrPhone;

    /**
     * 密码
     */
    private String password;
}
