package com.hxh.ui;


import com.hxh.dao.IAcountDao;
import com.hxh.service.IAcountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Hxh
 * @date: 2019/11/20
 * @description:
 *
 *
 * 获取spring的IOC核心容器，并根据ID获取对象
 */
public class Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAcountService as=(IAcountService)ac.getBean("accountService");
        IAcountDao adao=ac.getBean("accountDao",IAcountDao.class);
        System.out.println(as+" "+adao);
          }
}
