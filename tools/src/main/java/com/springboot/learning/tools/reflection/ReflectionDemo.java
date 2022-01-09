package com.springboot.learning.tools.reflection;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 使用spring反射，非java原生方法
 */
@Service
public class ReflectionDemo {

    /**
     * spring 方式的反射
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void reflection() throws InstantiationException, IllegalAccessException {
        Object obj = User.class.newInstance();
        // 获取带参数方法  1. 类型 2. 方法名  3... 参数类型数组
        Method initMethod = ReflectionUtils.findMethod(User.class, "init", String.class, int.class);
        System.out.println(initMethod);
        assert initMethod != null;
        // 执行带参数方法 1. 方法  2. 对象  3... 参数数组
        ReflectionUtils.invokeMethod(initMethod, obj, "zs", 20);
        // 获取不带参数方法
        Method getNameMethod = ReflectionUtils.findMethod(User.class, "getName");
        System.out.println(getNameMethod);
        assert getNameMethod != null;
        // 执行不带参数方法
        System.out.println(ReflectionUtils.invokeMethod(getNameMethod, obj));
        // 获取属性字段
        Field ageField = ReflectionUtils.findField(User.class, "age");
        assert ageField != null;
        // 设置属性可访问
        ReflectionUtils.makeAccessible(ageField);
        // 输出属性值
        System.out.println(ageField.getInt(obj));
        // 获取方法的注解
        Nullable annotation = AnnotationUtils.findAnnotation(initMethod, Nullable.class);
        System.out.println(annotation);
    }

}
