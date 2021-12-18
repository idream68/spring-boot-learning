package com.springboot.learning.learnswagger2.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户请求")
public class UserRequest {
    @ApiModelProperty("用户名称")
    String name;
    @ApiModelProperty("用户年龄")
    Integer age;
}
