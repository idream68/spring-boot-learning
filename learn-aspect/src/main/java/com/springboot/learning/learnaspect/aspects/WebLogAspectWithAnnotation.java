package com.springboot.learning.learnaspect.aspects;

import com.google.gson.Gson;
import com.springboot.learning.learnaspect.annotation.WebLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Editor zjhan
 * @Date 2021/12/14 21:11
 * @Description TODO
 */
@Aspect
@Component
@Slf4j
@Order(2)
public class WebLogAspectWithAnnotation {

    /**
     * 设置切点，使用注解方式
     */
    @Pointcut("@annotation(com.springboot.learning.learnaspect.annotation.WebLog)")
    public void weblogWithAnnotation() {

    }


    @Around("weblogWithAnnotation()")
    public Object doAroundWithAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.nanoTime();
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest request = attributes.getRequest();
        log.info("====================annotation Start==================");
//        log.info("Url:           {}", request.getRequestURL().toString());
//        log.info("HTTP Method:   {}", request.getMethod());
//        log.info("Class Method:  {}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
//        log.info("IP:            {}", request.getRemoteAddr());
//        log.info("Request Args:  {}", Arrays.toString(proceedingJoinPoint.getArgs()));

        // 获取注解中参数
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method signatureMethod = signature.getMethod();
        WebLog webLog = signatureMethod.getAnnotation(WebLog.class);
        log.info("annotation value: {}", webLog.value());
        Object result = proceedingJoinPoint.proceed();

        // 打印出参
        log.info("annotation Response Args: {}", new Gson().toJson(result));
        // 执行耗时
        log.info("annotation Time-Consuming: {} ms", (System.nanoTime() - startTime) / 1000000);
        log.info("=====================annotation End===================");
        return result;
    }


    @Before("weblogWithAnnotation()")
    public void doBefore(JoinPoint joinpoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        log.info("====================Start==================");
        log.info("Url:          {}", request.getRequestURL().toString());
        log.info("HTTP Method:  {}", request.getMethod());
        log.info("Class Method: {}.{}", joinpoint.getSignature().getDeclaringTypeName(), joinpoint.getSignature().getName());
        log.info("IP:           {}", request.getRemoteAddr());
        log.info("Request Args: {}", Arrays.toString(joinpoint.getArgs()));
    }

    @After("weblogWithAnnotation()")
    public void doAfter() {
        log.info("===================End==============");
    }
}
