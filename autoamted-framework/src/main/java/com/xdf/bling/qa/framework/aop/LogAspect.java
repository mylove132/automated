package com.xdf.bling.qa.framework.aop;

import com.xdf.bling.qa.common.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Slf4j
@Aspect
public class LogAspect {

    @Pointcut(value = "@annotation(com.xdf.bling.qa.common.annotation.Log)")
    public void logPointCut() {}


    @AfterReturning(pointcut = "logPointCut()")
    public void doAfterReturn(JoinPoint joinPoint) {

    }

    @AfterThrowing(value = "logPointCut()" , throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e);
    }

    private void handleLog(JoinPoint joinPoint, final Exception e) {

    }

    private Log getAnnotationLog (JoinPoint joinPoint) {
         Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getDeclaredAnnotation(Log.class);
        }
        return null;
    }
}
