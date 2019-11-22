package com.hxh.service.impl;

import com.hxh.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author: Hxh
 * @date: 2019/11/22
 * @description: 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");

    }

    public int delateAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
