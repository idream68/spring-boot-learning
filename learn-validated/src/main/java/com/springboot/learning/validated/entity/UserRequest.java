package com.springboot.learning.validated.entity;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.learning.validated.annotation.isEmail;
import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {

    @Size(min = 5, max = 20)
    private String userName;
    @Min(0)
    @Max(100)
    private int age;
    @NotNull
    private String nickName;
    @NotNull(message = "deleted 不能为空")
    @Pattern(regexp = "^[Y|N]$", message = "deleted 必须为Y/N")
    private String deleted;
    @isEmail
    private String userEmail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addTime;
}
