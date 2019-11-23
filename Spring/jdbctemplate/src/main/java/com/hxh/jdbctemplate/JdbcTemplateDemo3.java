package com.hxh.jdbctemplate;

import com.hxh.service.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Hxh
 * @date: 2019/11/22
 * @description:
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
       // jt.update("insert into account(name,money) values (?,?)","eee",3333f);
        //jt.update( "update  account set name=?,money=? where id=?","test",3456f,4);
//查找所有
       List<Account> accounts= jt.query("select * from account where money>?",new AccountRowMapper(),10f);

       for(Account account:accounts){
           System.out.println(account);
       }
    }
}

/**
 * 定义封装Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     *
     * 把结果集中的数据封装到Account，然后由spring把每个Account 加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */

    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account=new Account();
        account.setId(resultSet.getInt("id"));
        account.setMoney(resultSet.getFloat("money"));
        account.setName(resultSet.getString("name"));
        return account;
    }
}
