package com.springboot.learning.learnspringsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.learning.learnspringsecurity.entity.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRoleCodeByUserId(Long id);
}
