package com.hxh.service;

/**
 * @author: Hxh
 * @date: 2019/11/22
 * @description:
 */
public interface IAccountService {
    /**
     * 模拟保存账户
     * 无参无返回值方法
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * 无返回值有参
     *
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * 有返回值 无参
     * @return
     */

    int delateAccount();
}
