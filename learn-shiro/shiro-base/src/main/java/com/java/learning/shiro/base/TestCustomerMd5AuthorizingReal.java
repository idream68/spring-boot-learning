package com.java.learning.shiro.base;

import com.java.learning.shiro.base.real.CustomerMd5Real;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;


public class TestCustomerMd5AuthorizingReal {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        CustomerMd5Real customerMd5Real = new CustomerMd5Real();
        // 设置加密算法
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("SHA-1");
        // 设置散列次数
        hashedCredentialsMatcher.setHashIterations(1024);
        customerMd5Real.setCredentialsMatcher(hashedCredentialsMatcher);
        securityManager.setRealm(customerMd5Real);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("test", "123");
        try {
            System.out.println(subject.isAuthenticated());
            subject.login(token);
            System.out.println(subject.isAuthenticated());
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("无效用户");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }


        // 查看权限
        if (subject.isAuthenticated()) {
            // 基于角色权限控制
            System.out.println("是否有权限: " + subject.hasRole("admin"));

            // 基于多角色权限控制(一直判断到第一个无角色为止)
            System.out.println("是否具有所有权限: " + subject.hasAllRoles(Arrays.asList("super", "admin")));

            // 查看是否具有其中一个角色 (有几个角色就判断几次)
            boolean[] hasRoles = subject.hasRoles(Arrays.asList("super", "admin"));
            for (boolean hasRole : hasRoles) {
                System.out.println("是否具有其中某个权限: " + hasRole);
            }

            // 基于权限判断  资源标识符:操作:资源类型
            System.out.println("权限: " + subject.isPermitted("user:add:01"));
            System.out.println("权限： " + subject.isPermitted("user:add:*"));

            // 分别具有哪些权限  有几个调用几次
            boolean[] permitteds = subject.isPermitted("user:*:01", "user:add:*", "user:add:01");
            for (boolean permitted: permitteds) {
                System.out.println("权限： " + permitted);
            }

            // 同时具有哪些权限（一直判断到没有权限为止）
            boolean permitted = subject.isPermittedAll("user:*:01", "user:add:*", "user:add:01");
            System.out.println("权限： " + permitted);

        }
    }
}
