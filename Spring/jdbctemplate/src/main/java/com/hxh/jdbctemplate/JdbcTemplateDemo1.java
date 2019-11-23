package com.hxh.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

/**
 * @author: Hxh
 * @date: 2019/11/22
 * @description: template最基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源 Spring内置数据源
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring");
        ds.setUsername("root");
        ds.setPassword("617662");
        //1.创建jdbctemplate对象
        JdbcTemplate jt=new JdbcTemplate();

jt.setDataSource(ds);
        //2.执行操作
        jt.execute("insert into account(name,money) values('ccc',1000)");
    }
}
