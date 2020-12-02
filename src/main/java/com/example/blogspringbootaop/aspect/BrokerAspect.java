package com.example.blogspringbootaop.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.Easy;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.DoubleSummaryStatistics;

/**
 * 通知（增强）演示
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

    //接收参数的方法
    @Pointcut("execution(* com.example.blogspringbootaop.controller.AOPController.f(String)) && args(money))")
    public void ParamAspect(String money){}

    //接收参数的方法
    @Pointcut("execution(* com.example.blogspringbootaop.controller.AOPController.g(..))")
    public void ParamAspectBody(){}

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

    @Around("BrokerAspect()")
    public void Around(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("（今天是个晴朗的一天，太阳红彤彤，花儿五颜六色）");//在before前执行
            joinPoint.proceed();
            log.info("（这时老板沉吟了一会。。。。）");//在切点运行后，around前执行
    }

    @Around("ParamAspect(money)")
    public void AroundParam(ProceedingJoinPoint joinPoint,String money) throws Throwable {
        //log.info("（今天是个晴朗的一天，太阳红彤彤，花儿五颜六色）");//在before前执行
        joinPoint.proceed();
        log.info("（这一份估计要"+money+"钱。。。。）");//在切点运行后，around前执行
    }

    @Around("ParamAspectBody()")
    public void ParamAspectBody(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        JSONObject jsonObject = JSONObject.parseObject((String) args[0]);
        Easy easy = JSON.toJavaObject(jsonObject,Easy.class);
        String name = easy.getName();
        String age = easy.getAge();

        joinPoint.proceed();

        log.info("（"+name+":"+age+"）");
    }
}
