package com.zzidc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyAspect
 * @Author chenxue
 * @Description TODO
 * @Date 2019/4/1 9:45
 **/
@Aspect
@Component
public class MyAspect {
    @Around("execution(* com.zzidc.web.controller.UserController.*(..))")
    public Object myAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("切面编程开始");
        for(Object obj:proceedingJoinPoint.getArgs()){
            System.out.println(obj);
        }
        Long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("耗时:" + (System.currentTimeMillis() - startTime));
        System.out.println("切面编程结束");
        return obj;
    }
}
