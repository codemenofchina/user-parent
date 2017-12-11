package com.gimefive.user.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodAspect {

    @Before("execution(* com.gimefive.user.service.*.*(..))")
    public void beforeMethod() {

//        System.out.println(pjp.getTarget().toString());
        System.out.println("before");
    }

    @After("execution(* com.gimefive.user.service.*.*(..))")
    public void afterMethod() {
//        System.out.println(pjp.getTarget().toString());
        System.out.println("after");
    }

    @Around("execution(* com.gimefive.user.service.*.*(..))")
    public void aroundMethod(ProceedingJoinPoint pjp) {
        System.out.println(pjp.getTarget().toString());
        System.out.println("around");
    }
}
