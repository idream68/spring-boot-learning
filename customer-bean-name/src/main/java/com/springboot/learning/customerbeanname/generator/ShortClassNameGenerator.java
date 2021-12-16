package com.springboot.learning.customerbeanname.generator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.util.ClassUtils;

import java.util.Objects;

public class ShortClassNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        String beanName = ClassUtils.getShortName(Objects.requireNonNull(definition.getBeanClassName()));
        System.out.println(beanName);
        return beanName;
    }
}
