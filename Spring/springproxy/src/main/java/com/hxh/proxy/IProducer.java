package com.hxh.proxy;

/**
 * @author: Hxh
 * @date: 2019/11/22
 * @description:对生产厂家
 */
public interface IProducer {
    public void saleProduct(float money);

    public void afterService(float money);
}
