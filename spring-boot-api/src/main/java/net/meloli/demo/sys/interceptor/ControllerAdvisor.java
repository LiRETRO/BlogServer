package net.meloli.demo.sys.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAdvisor {

    ThreadLocal<Long> timeHolder = new ThreadLocal<>();

    /**
     * 切入点
     * 切入Controller包下所有类的所有方法
     */
//    @Pointcut("execution(* *..*controller*..*(..)) && within(*..*ob.controller*..*)") 切入点controller包下所有方法，并且只切入ob包下的controller
    @Pointcut("execution(* *..*controller*..*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
    }


}
