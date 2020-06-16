package com.maven.springboot.demo.config;

import com.maven.springboot.demo.server.TestService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <br>@Configuration</br>表示该类是一个配置类
 */
@Configuration
public class JavaConfig {


    /**
     * @Bean  表示返回一个Bean  ,并且可以交给spring 去管理
     * @return
     */
    @Bean
    public TestService getService(){
        return new TestService();
    }
    
}