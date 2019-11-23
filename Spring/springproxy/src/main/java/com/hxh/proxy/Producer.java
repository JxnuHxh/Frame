package com.hxh.proxy;

/**
 * @author: Hxh
 * @date: 2019/11/22
 * @description:一个生产者
 */
public class Producer implements IProducer {
    public void saleProduct(float money){
        System.out.println("拿到钱，销售产品"+money);
    }
    public void afterService(float money){
        System.out.println("提供售后服务"+money);
    }
}
