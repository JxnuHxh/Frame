package com.hxh.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author: Hxh
 * @date: 2019/11/21
 * @description: 连接工具类 它从数据源中获取一个连接，并且直线线程的绑定
 */
public class ConnectionUtils {
    private  ThreadLocal<Connection> t=new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //获取当前线程上的连接
    public Connection getThreadConnection(){
        //1.先从Threadlocal上获取
        Connection conn=t.get();
        try {


        //2.判断当前线程上是否有连接
        if(conn==null)
        {
            //3.从数据源中获取一个连接，并存入Threadlocal上
            conn=dataSource.getConnection();
            t.set(conn);
          }
          return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
//把连接和线程解绑
    public void removeConnection(){
        t.remove();
    }


}
