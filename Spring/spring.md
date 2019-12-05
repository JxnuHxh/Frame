1.基础（IOC 控制反转 ，DI 依赖注入), 整合Junit 整合web
2.AOP 切面编程， 
3.JdbcTemplate
3.事务处理
IOC相当于Map
spring概述  
    spring是什么
## spring用于创建对象的注解  功能相当于XML配置中的<bean>    
@Component 把当前类对象存入Spring容器中   
不写参数就默认value=类名首字母小写  
<cotext:component-scan base-package="com.hxh"> 表示扫描com.hxh下所有注解
@Controller  
@Service  
@REspository  
这三个注解与@Conponent一样 可以使我们三层对象更加清晰  

## 用于注入对象的注解 作用相当于在XML中<bean>写的<property>标签  
@Autowrited 自动按类型注入 只要容器中有唯一的bean对象类型和  
	要注入的变量类型匹配就可以注入成功 父类型也可以  
@Qualifier 按照类型注入的基础上按名称注入 不能单独使用   

@Resource 直接按照<bean> 的id注入 可以独立使用   

@Value 用于注入基本类型和String类型的数据  

## 用于改变作用范围的注解 与在<bean>中使用scope属性功能类似  
@scope 指定bean的作用范围  
参数默认为singletion  属性prototype为多例  
## 关于生命周期的注解 作用相当于<bean>中使用init-method和destroy
@PreDestroy 用于指定销毁方法   
@PostConstruct 用于指定初始化方法  


@Configuration 指定改类是一个配置类 其作用相当于bean.xml    
@Componentscan 通过注解指定Spring在创建容器时要扫描的包   
@Bean 用于把当前方法的返回值作为bean对象存入spring的IOC容器中
  默认key是方法名  

细节 当我们用注解配置方法时 如果方法有参数 spring框架会去容器中查找有没有可用的bean对象  
查找方法和Autowried注解作用一样  
@Input 用于导入其他配置类
（jdbcConfig.class）参数时数组 可以指定多个 主配置类是所有配置类的父类  
@PropertySource  用于指定properties文件的位置  
（ClassPath：类地址）



