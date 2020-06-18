package com.maven.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 * 
 * 错误 Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
 * 出现错误 Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating
 *  bean with name 'linkDiscoverers' defined in class path resource [org/springframework/hateoas/config/HateoasConfiguration.class]:
 * 基本是swagger  和springboot 版本不匹配
 * 
 * 
 * 
 * 2.http://localhost:8080/demo/v2/api-docs
 * 打开错误 :Illegal DefaultValue null for parameter type integer
 * 解决方案 1：
 * 就是说如果实体属性类型是Integer，就把example转为Long类型，而example默认为"",导致转换错误。
 * 可以将 int 型的 example 设置为1 参考 User 类的 age 字段
 *  2： pom.xml中处理 ，目前采用该方式
 * 
 * 
 *
 * 
 */
@Configuration
@EnableSwagger2
//是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
// @ConditionalOnProperty(name = "swagger.enable",  havingValue = "true")
public class SwaggerConfig {
    
    @Bean
    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
         // 指定构建api文档的详细信息的方法：apiInfo()
        .apiInfo(apiInfo())
        .select()
         // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller中的所有接口
        .apis(RequestHandlerSelectors.basePackage("com.maven.springboot.demo.control"))
        .paths(PathSelectors.any())
        .build();

    }



    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
        .title("学习springboot")
        .description("swagger2 接口描述")
        .contact(new Contact("yancheng", "http://localhost:8080", "yanchengdeng@gmail.com"))
        .version("1.0")
        .build();
    }
    
}