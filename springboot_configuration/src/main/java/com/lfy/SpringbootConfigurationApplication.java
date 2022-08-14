package com.lfy;

import com.alibaba.druid.pool.DruidDataSource;
import com.lfy.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class)
public class SpringbootConfigurationApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource datasource(){
        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootConfigurationApplication.class, args);
        ServerConfig bean = applicationContext.getBean(ServerConfig.class);
        System.out.println(bean);
        DruidDataSource ds = applicationContext.getBean(DruidDataSource.class);
        System.out.println(ds.getDriverClassName());
    }

}
