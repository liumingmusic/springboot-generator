package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HandlerLogAspect
 * @Description: 实现自定义拦截切面类
 * @author doubleM
 * @date 2018年3月16日 下午3:59:24 
 *
 */
@Component
@Aspect
public class AspectExample {

    @Pointcut(value = "@annotation(com.example.aop.AopExample)")
    public void access() {

    }

    @Before("access()")
    public void deBefore(JoinPoint joinPoint) {
        System.out.println("second before");
    }

    @Around("@annotation(handlerLog)")
    public Object around(ProceedingJoinPoint pjp, AopExample handlerLog) {
        // 获取注解里的值
        System.out.println("second around:" + handlerLog.desc());
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
