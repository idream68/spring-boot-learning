package com.springboot.learning.learnspringsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.learning.learnspringsecurity.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT username, password, nickname, phone, email, birthday, sex, status, create_time, update_time FROM sec_user WHERE username = #{username}")
    User getUserByUsername(String username);
}
