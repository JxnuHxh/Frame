package com.hxh.dao;

import com.hxh.service.Account;

/**
 * @author: Hxh
 * @date: 2019/11/22
 * @description:
 */
public interface IAccountDao {
    Account findAccountById(Integer accountId);
    Account findAccountByName(String accountName);
    void updateAccount(Account account);


}
