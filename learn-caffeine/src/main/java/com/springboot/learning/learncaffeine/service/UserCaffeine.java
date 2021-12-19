package com.springboot.learning.learncaffeine.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.springboot.learning.learncaffeine.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserCaffeine {
    Logger log = LoggerFactory.getLogger(UserCaffeine.class);

    private final Cache<Integer, User> userCaffeine = Caffeine.newBuilder()
            .maximumSize(10)
            .expireAfterAccess(1, TimeUnit.MINUTES)
            .expireAfterWrite(2, TimeUnit.MINUTES)
            .build();

    public void addUser(User user) {
        userCaffeine.put(user.getId(), user);
    }

    public User getUser(int userId) {
        return userCaffeine.getIfPresent(userId);
    }

    public Map<Integer, User> getAllUser(List<Integer> userIds) {
        return userCaffeine.getAllPresent(userIds);
    }
}
