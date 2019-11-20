package com.hxh.ui;

import com.hxh.factory.BeanFactory;
import com.hxh.service.Account;
import com.hxh.service.IAcountService;

/**
 * @author: Hxh
 * @date: 2019/11/20
 * @description:
 */
public class Client {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //IAcountService as= (IAcountService) BeanFactory.getBean("accountService");
        for(int i=0;i<5;i++){
            IAcountService as= (IAcountService) BeanFactory.getBean("accountService");
            //每个类都不一样 不是单例模式
            System.out.println(as);
            as.saveAccount();
        }

    }
}
