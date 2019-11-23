package com.hxh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author: Hxh
 * @date: 2019/11/20
 * @description:
 */

//程序的耦合
//也就是程序间的依赖关系
    //包括类之间的依赖关系 方法之间的依赖关系
    //如下没有驱动包就没法编译成功
    //解耦就是降低程序之间的依赖关系
    //实际开发中:应该编译期不依赖 运行时才依赖

    /*
    *解耦的思路：
    * 第一步使用反射来创建对象 而避免使用new关键字
    * 第二步 通过读取配置文件来获取要创建的对象全限定类名
     */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
       // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得链接
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","617662");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm=conn.prepareStatement("select* from account");
        //4.执行SQl，获得结果集
        ResultSet rs=pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        conn.close();
    }


}
