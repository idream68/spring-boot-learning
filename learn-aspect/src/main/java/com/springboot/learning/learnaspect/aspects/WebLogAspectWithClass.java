package com.springboot.learning.learnaspect.aspects;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Aspect
@Component
@Order(1)
public class WebLogAspectWithClass {
    private final Logger log = LoggerFactory.getLogger(WebLogAspectWithClass.class);
    /**
     * 设置切点，按照方法名方式
     */
    @Pointcut("execution(public * com.springboot.learning.learnaspect.controller..*.*(..))")
    public void weblogWithClassName() {

    }

    /**
     * before 在切点之前执行
     * @param joinpoint
     */
    @Before("weblogWithClassName()")
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

    /**
     * after: 在切点之后执行
     */
    @After("weblogWithClassName()")
    public void doAfter() {
        log.info("===================End==============");
    }

    /**
     * around: 在切点前，后都会执行
     * proceedingJoinPoint.proceed: 执行方法
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("weblogWithClassName()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.nanoTime();
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest request = attributes.getRequest();
//        log.info("====================Start==================");
//        log.info("Url:           {}", request.getRequestURL().toString());
//        log.info("HTTP Method:   {}", request.getMethod());
//        log.info("Class Method:  {}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
//        log.info("IP:            {}", request.getRemoteAddr());
//        log.info("Request Args:  {}", Arrays.toString(proceedingJoinPoint.getArgs()));
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("Response Args: {}", new Gson().toJson(result));
        // 执行耗时
        log.info("className Time-Consuming: {} ms", (System.nanoTime() - startTime) / 1000000);
        log.info("=====================End===================");
        return result;
    }

}
