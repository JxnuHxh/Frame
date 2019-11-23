package com.hxh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: Hxh
 * @date: 2019/11/23
 * @description:
 */
@Configuration
@ComponentScan("com.hxh")
@Import({JdbcConfig.class,TranscationConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement //开启注解支持
public class SpringConfiguration {

}
