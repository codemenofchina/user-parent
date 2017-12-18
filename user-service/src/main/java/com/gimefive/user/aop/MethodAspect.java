package com.gimefive.user.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class MethodAspect {

    @Pointcut("execution(* com.gimefive.user.service.*.*(..))")
    public void aopMethod() {}

    @Before("aopMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("before");
        for (Object obj : joinPoint.getArgs()) {
            System.out.println(obj);
        }
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName());
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        System.out.println(targetMethod.getName());
    }

    @After("aopMethod()")
    public void afterMethod() {
        System.out.println("after");
    }

    @Around("aopMethod()")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around");
        for (Object obj : pjp.getArgs()) {
            System.out.println(obj);
        }
        Signature signature = pjp.getSignature();
        System.out.println(signature.getName());
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        System.out.println(targetMethod.getName());
        return pjp.proceed();
    }
}
