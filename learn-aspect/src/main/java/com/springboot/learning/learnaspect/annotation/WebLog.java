package com.springboot.learning.learnaspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zjhan
 * @Date: 2021/4/22 20:42
 * @Description: 使用本注解 自动插入日志
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebLog {
    String value() default "";
}
