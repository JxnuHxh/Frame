package com.hxh.service.impl;

import com.hxh.dao.IAccountDao;
import com.hxh.domain.Account;
import com.hxh.service.IAccountService;
import com.hxh.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService{

    private IAccountDao accountDao;
    private TransactionManager txManger;

    public void setTxManger(TransactionManager txManger) {
        this.txManger = txManger;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Autowired
    public List<Account> findAllAccount() {
        try{
            //1.开启事务
            txManger.beginTransction();
            //2.执行操作
            List<Account> accounts=accountDao.findAllAccount();
            //3.提交事务
            txManger.commit();
            //4.返回结果
            return accounts;

        }catch (Exception e){
            //5.回滚操作
            txManger.rollback();
            throw new RuntimeException(e);//表示产生异常就不再执行
        }finally {
            //6.释放连接
            txManger.release();
        }

    }

    @Autowired
    public Account findAccountById(Integer accountId) {
        try{
            //1.开启事务
            txManger.beginTransction();
            //2.执行操作
            Account account=accountDao.findAccountById(accountId);
            //3.提交事务
            txManger.commit();
            //4.返回结果
            return account;

        }catch (Exception e){
            //5.回滚操作
            txManger.rollback();
            throw new RuntimeException(e);

        }finally {
            //6.释放连接
            txManger.release();
        }
    }

    @Autowired
    public void saveAccount(Account account) {
        try{
            //1.开启事务
            txManger.beginTransction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManger.commit();

        }catch (Exception e){
            //5.回滚操作
            txManger.rollback();

        }finally {
            //6.释放连接
            txManger.release();
        }
    }

    @Autowired
    public void updateAccount(Account account) {
        try{
            //1.开启事务
            txManger.beginTransction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManger.commit();

        }catch (Exception e){
            //5.回滚操作
            txManger.rollback();

        }finally {
            //6.释放连接
            txManger.release();
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            //1.开启事务
            txManger.beginTransction();
            //2.执行操作
            accountDao.deleteAccount(accountId);
            //3.提交事务
            txManger.commit();


        }catch (Exception e){
            //5.回滚操作
            txManger.rollback();

        }finally {
            //6.释放连接
            txManger.release();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {

        try {
            System.out.println("断电1");
            //1.开启事务
            txManger.beginTransction();
            //2.执行操作
            // 1.根据名称查询转出账户

            Account source = accountDao.findAccountByName(sourceName);
            //2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //3 转出账户扣钱
            source.setMoney(source.getMoney() - money);
            //4.转入账户加钱
            target.setMoney(target.getMoney() + money);
            //5.更新转出账户
            accountDao.updateAccount(source);
            //来个异常
            int i = 1 / 0;

            //6.更新转入账户
            accountDao.updateAccount(target);


            //3.提交事务
            txManger.commit();


        } catch (Exception e) {
            //5.回滚操作
            txManger.rollback();

        } finally {
            //6.释放连接
            txManger.release();
        }
        //1.根据名称查询转出号
        //2.根据名称查询转入号

    }
}


