package com.hxh.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author: Hxh
 * @date: 2019/11/20
 * @description:
 *
 * 一个创建Bean对象的工厂
 * Bean是可重用组件
 *
 * 第一 需要一个配置文件来配置我们的service和dao
 * 配置的内容  唯一标识=全限定类名（key=value） 也就是properties 配置文件
 * 第二 通过读取配置文件中配置的内容，反射创建对象
 */
public class BeanFactory {
    private  static Properties props;

    //定义一个Map,用于存放我们要创建的对象，我们把它称之为容器
    private static Map<String, Object> beans;
    static  {
        //实例化对象
        props=new Properties();
        //获取Properties
        InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中的所有Key
            Enumeration<Object> keys=props.keys();
            //遍历
            while(keys.hasMoreElements()){
                String key=keys.nextElement().toString();
                //根据key获取value
                String beanPath=props.getProperty(key);
                //反射创建对象
                Object value=Class.forName(beanPath).newInstance();
                //把key和 value存入容器中
                beans.put(key,value);
            }
        } catch (IOException e) {
           throw new ExceptionInInitializerError("初始化失败");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Object getBean(String beanName) {
      return beans.get(beanName);

    }
  /*  public static Object getBean(String beanName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object bean;
        String beanPath=props.getProperty(beanName);
        bean=Class.forName(beanPath).newInstance();//每次都调用默认构造函数创建对象
        return bean;

    }*/

}
