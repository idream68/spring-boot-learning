package com.springboot.learning.learnspringsecurity.entity;

import lombok.Data;

@Data
public class RolePermissionKey {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long permissionId;
}
