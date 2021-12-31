package com.springboot.learning.learnspringsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.learning.learnspringsecurity.entity.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("SELECT id, name, url, type, permission, sort, parent_id")
    List<Permission> getPermissionByUserId(Long id);
}
