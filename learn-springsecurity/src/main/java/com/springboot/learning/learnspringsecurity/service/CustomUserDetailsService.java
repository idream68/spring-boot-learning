package com.springboot.learning.learnspringsecurity.service;

import com.springboot.learning.learnspringsecurity.entity.Permission;
import com.springboot.learning.learnspringsecurity.entity.Role;
import com.springboot.learning.learnspringsecurity.entity.User;
import com.springboot.learning.learnspringsecurity.mapper.PermissionMapper;
import com.springboot.learning.learnspringsecurity.mapper.RoleMapper;
import com.springboot.learning.learnspringsecurity.mapper.UserMapper;
import com.springboot.learning.learnspringsecurity.vo.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByUsername(username);
        // 设置权限
        List<Role> roleList = new ArrayList<>();
        List<Permission> permissions = new ArrayList<>();
        if (username.equals("admin")) {
            Permission permission = new Permission();
            permission.setMethod(HttpMethod.GET.name());
            permission.setUrl("/**");
            permission.setType(1);
            permissions.add(permission);
            Permission permission1 = new Permission();
            permission1.setMethod(HttpMethod.POST.name());
            permission1.setUrl("/**");
            permission1.setType(1);
            permissions.add(permission1);
        }
        return UserPrincipal.create(user, roleList, permissions);
    }
}
