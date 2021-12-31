package com.springboot.learning.learnspringsecurity.service;

import com.springboot.learning.learnspringsecurity.config.BaseConstant;
import com.springboot.learning.learnspringsecurity.vo.UserPrincipal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class UserCacheService {
    @Resource
    RedisDao<String, UserPrincipal> userRedis;


    public UserPrincipal getUserFromCache(HttpServletRequest request) {
        String baseToken = request.getHeader("Auth");
        return userRedis.getValue(getCacheKey(baseToken));
    }

    public void removeUser(HttpServletRequest request) {
        String baseToken = request.getHeader("Auth");
        userRedis.del(getCacheKey(baseToken));
    }

    public String saveUser(UserPrincipal userPrincipal) {
        String uuid = UUID.randomUUID().toString();
        String tokenKey = getCacheKey(uuid);
        userRedis.setKey(tokenKey, userPrincipal, null);
        return uuid;
    }

    private String getCacheKey(String baseKey) {
        String k1 = String.join(BaseConstant.USER_BETWEEN, baseKey.split("-"));
        return BaseConstant.USER_KEY + k1;
    }
}
