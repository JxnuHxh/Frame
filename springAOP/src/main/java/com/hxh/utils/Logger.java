package com.hxh.utils;

/**
 * @author: Hxh
 * @date: 2019/11/22
 * @description:用于记录日志的工具类 提供公共的代码
 */
public class Logger {

    /**
     * 用于打印日志 计划让其在切入点方法执行之前执行
     */
    public void printLog(){
    System.out.println("Logger类中的printLog开始记录日志");
    }

}
