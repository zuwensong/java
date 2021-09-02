package com.zuwen.basic.aop;

import com.zuwen.basic.util.DateTimeDemo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Objects;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.zuwen.basic.aop.Log)")
    public void log() {
    }

    @Before(value = "log()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(className + "," + methodName);
    }

    @AfterReturning(pointcut = "log()", returning = "jsonResult")
    public void afterReturning(JoinPoint joinPoint, Object jsonResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("USER_ID[");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Log log = Objects.isNull(method) ? null : method.getAnnotation(Log.class);
        sb.append(Objects.isNull(log) ? null : log.value()).append("]-");
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        sb.append("[").append(className).append(".").append(methodName).append("]-");
        sb.append("RESPONSE[").append(jsonResult.toString()).append("]-");
        sb.append("TIME[").append(DateTimeDemo.getDateTimeString(LocalDateTime.now())).append("]");
        System.out.println(sb);
    }
}
