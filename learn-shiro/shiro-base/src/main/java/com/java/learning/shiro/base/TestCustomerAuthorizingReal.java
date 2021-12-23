package com.java.learning.shiro.base;

import com.java.learning.shiro.base.real.CustomerReal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

public class TestCustomerAuthorizingReal {
    public static void main(String[] args) {
        // 1. 创建安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 2. 给安全管理器设置realm
        securityManager.setRealm(new CustomerReal());
        // 3. SecurityUtils给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 4. 关键对象subject主体
        Subject subject = SecurityUtils.getSubject();
        // 5. 创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("test", "123");
        // 6. 登录(认证)
        try {
            System.out.println("认证状态: " + subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证状态: " + subject.isAuthenticated());
            subject.logout();
            System.out.println("认证状态: " + subject.isAuthenticated());
        } catch (UnknownAccountException e) {
            System.out.println("无有效用户");
            e.printStackTrace();
        } catch (IncorrectCredentialsException e1) {
            System.out.println("密码错误");
            e1.printStackTrace();
        }
    }
}
