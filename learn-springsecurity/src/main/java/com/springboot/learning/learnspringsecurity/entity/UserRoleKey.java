package com.springboot.learning.learnspringsecurity.entity;

import lombok.Data;

@Data
public class UserRoleKey {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;
}
