package com.example.blogspringbootaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 付疆疆
 * @date 2020/12/2 8:18
 */
@Aspect
@Component
@Slf4j
public class BrokerAspect {
    /**
     * 定义切点，切入点为 com.example.blogspringbootaop.controller.AOPController中所有方法
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(* com.example.blogspringbootaop.controller.AOPController.*(..))")
    public void BrokerAspect(){}

    /**
     * 在连接点执行之前执行的通知
     */
    @Before("BrokerAspect()")
    public void before(){
        log.info("小伙子你要买啥？");
    }

    /**
     * 在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("BrokerAspect()")
    public void after(){
        log.info("稍等一下，我去给你康康有没有");
    }

    /**
     *在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("BrokerAspect()")
    public void AfterReturning(){
        log.info("给你拿来了，这个要xxxxx钱");
    }

    /**
     * 在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("BrokerAspect()")
    public void AfterThrowing(){
        log.info("抱歉卖完了，你下次再来吧");
    }
}
