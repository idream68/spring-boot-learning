package com.springboot.learning.learnshirospring.config;

import com.springboot.learning.learnshirospring.shiro.realm.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
//    创建shiroFilter

    /**
     * 负责拦截所有请求
     * @return
     */
    @Bean
    ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        // 配置系统受限资源
        // 配置系统公共资源
        Map<String, String> map = new HashMap<>();
        map.put("/index", "authc"); // 资源需要认证和授权


        return shiroFilterFactoryBean;

    }
//    创建安全管理器
    @Bean
    DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
//    创建自定义realm
    @Bean
    Realm realm() {
        return new CustomerRealm();
    }
}
