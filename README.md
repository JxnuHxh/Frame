# 框架的深入学习

#### Mybatis   

#### Spring
   spring框架的概述以及spring中基于XML的IOC配置  
   spring中基于注解的IOC和ioc的案例 ioc作用是消减程序的耦合    
   spring中的aop和基于XML以及注解的AOP配置  
   spring中的JdbcTemlate以及Spring事务控制   
-----------------------------------------------------
1、spring的概述
	spring是什么
	spring的两大核心
	spring的发展历程和优势
	spring体系结构
2、程序的耦合及解耦
	曾经案例中问题
	工厂模式解耦
3、IOC概念和spring中的IOC
	spring中基于XML的IOC环境搭建
4、依赖注入（Dependency Injection）

   程序的耦合也就是程序间的依赖关系   
    包括类之间的依赖关系 方法之间的依赖关系   
    如下没有驱动包就没法编译成功   
    解耦就是降低程序之间的依赖关系   
    实际开发中:应该编译期不依赖 运行时才依赖  

    
   解耦的思路：
   第一步使用反射来创建对象 而避免使用new关键字
   第二步 通过读取配置文件来获取要创建的对象全限定类名
   下面是以前的JDBC链接数据库
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
     

#### SpringBoot  
springboot 解决了复杂的配置和混乱的依赖
内置Tomcat提高自动配置  
是搭建Spring应用的脚手架  



