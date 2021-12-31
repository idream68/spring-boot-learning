package com.springboot.learning.learnspringsecurity.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;


import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UrlLoader implements ApplicationContextAware {
    private Multimap<String, String> urlMapping = ArrayListMultimap.create();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();

        handlerMethods.forEach((k, v) -> {
            // 获取当前 key 下的获取所有URL
            PathPatternsRequestCondition pathPatternsCondition = k.getPathPatternsCondition();
            if (!Objects.isNull(pathPatternsCondition)) {
                Set<String> patterns = pathPatternsCondition.getPatterns().stream().map(PathPattern::getPatternString).collect(Collectors.toSet());
                RequestMethodsRequestCondition method = k.getMethodsCondition();

                // 为每个URL添加所有的请求方法
                patterns.forEach(s -> urlMapping.putAll(s, method.getMethods().stream().map(Enum::toString).collect(Collectors.toList())));
            }});
    }

    public Multimap<String, String> getUrlMapping() {
        return urlMapping;
    }
}
