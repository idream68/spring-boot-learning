package com.java.learning.shiro.base;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class TestAuthenticator {
    public static void main(String[] args) {
        // 创建安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 给安全管理器设置realm
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        // SecurityUtils给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 关键对象subject主体
        Subject subject = SecurityUtils.getSubject();
        // 创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("test1", "123");
        // 登录
        subject.login(token);
    }
}
