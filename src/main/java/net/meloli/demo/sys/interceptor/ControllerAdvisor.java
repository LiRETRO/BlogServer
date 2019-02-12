package net.meloli.demo.sys.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
    @Pointcut("execution(* *..*controller*..*(..))")
    public void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


}
