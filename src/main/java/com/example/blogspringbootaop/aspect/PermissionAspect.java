package com.example.blogspringbootaop.aspect;

import com.example.blogspringbootaop.annotation.HasPermissions;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author tenpaper
 * @date 2020/12/2 16:21
 */
@Aspect
@Component
@Slf4j
public class PermissionAspect {

    @Pointcut("@annotation(com.example.blogspringbootaop.annotation.HasPermissions)")
    public void PermissionBody(){}

    @Around("PermissionBody()")
    public void haspermission(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(getAnnotationLog(joinPoint).value());
        joinPoint.proceed();
    }


    /**
     * 是否存在注解，如果存在就获取
     */
    private HasPermissions getAnnotationLog(JoinPoint joinPoint)
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null)
        {
            return method.getAnnotation(HasPermissions.class);
        }
        return null;
    }
}
