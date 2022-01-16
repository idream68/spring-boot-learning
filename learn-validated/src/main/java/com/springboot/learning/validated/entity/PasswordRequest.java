package com.springboot.learning.validated.entity;

import com.springboot.learning.validated.annotation.IsPassword;
import lombok.Data;

import java.io.Serializable;

@Data
@IsPassword
public class PasswordRequest implements Serializable {
    private String username;
    private String code;
    private String password;
}
