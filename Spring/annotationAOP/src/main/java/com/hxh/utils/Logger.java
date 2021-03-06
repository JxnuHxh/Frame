package com.hxh.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: Hxh
 * @date: 2019/11/22
 * @description:用于记录日志的工具类 提供公共的代码
 */
@Component("logger")
@Aspect //表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.hxh.service.impl.*.*(..))")
    private void pt1(){};
    /**
     * 前置通知
     */
   // @Before("pt1()")
    public void beforePrintLog(){
    System.out.println("前置通知Logger类中的beforePrintLog开始记录日志");
    }

    /**
     * 后置通知
     */
   // @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog开始记录日志");
    }
    /**
     * 异常通知
     */
   // @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog开始记录日志");
    }
    /**
     * 最终通知
     */
   // @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的printLog开始记录日志");
    }

    /**
     * 开环绕通知
     *
     */
   @Around("pt1()")
   public Object aroundPrintLog(ProceedingJoinPoint pjp){
       Object rtValue=null;
       try{
           Object[] args=pjp.getArgs();//得到方法执行所需要的参数
           System.out.println("Logger类中的aroundPringLog方法开始记录日子--前置");
         rtValue=  pjp.proceed(args);          //明确待用业务层代码（切入点方法）
           System.out.println("Logger类中的aroundPringLog方法开始记录日子---后置");
           return rtValue;

       }catch (Throwable t){
           System.out.println("Logger类中的aroundPringLog方法开始记录日子---异常");
           throw new RuntimeException(t);

       }finally {
           System.out.println("Logger类中的aroundPringLog方法开始记录日子---最终");
       }


   }
}
