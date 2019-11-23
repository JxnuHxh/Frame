package com.hxh.service;

import com.hxh.dao.IAcountDao;
import com.hxh.factory.BeanFactory;

import java.util.Date;

/**
 * @author: Hxh
 * @date: 2019/11/20
 * @description:
 */
public class Account implements IAcountService{
    //如果是经常变化的数据则不适用于注入方式

    // private IAcountDao acountDao=new com.hxh.dao.Account(); //依赖性过强
   private IAcountDao acountDao= (IAcountDao) BeanFactory.getBean("accountDao");

    public Account() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    }

    public void saveAccount() {
        int i=1;
        acountDao.saveAccount();
        System.out.println(i);

        i++;
    }
}
