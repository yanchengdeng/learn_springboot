package com.maven.springboot.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
// @Compent 一样的作用是 把该类 作为组件 放到 spring 容器中
// `@ConfigurationProperties` 注解并且使用 prefix 来指定一个前缀，然后该类中的属性名就是配置中去掉前缀后的名字，
//注意 :使用 `@ConfigurationProperties` 注解需要导入它的依赖：
// <dependency>
// 	<groupId>org.springframework.boot</groupId>
// 	<artifactId>spring-boot-configuration-processor</artifactId>
// 	<optional>true</optional>
// </dependency>

@Component
@ConfigurationProperties(prefix = "url")
public class ApplicationValues {

    private String  orderUrl;//: http://dyc.orderUrl.com
    private String userUrl;//: http://dyc.userUrl.com
    private String shopUrl;//: http://dyc.shopUrl.com
    private String  masterUrl;//: http://dyc.masterUrl.com
	public String getOrderUrl() {
		return orderUrl;
	}
	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}
	public String getUserUrl() {
		return userUrl;
	}
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}
	public String getShopUrl() {
		return shopUrl;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	public String getMasterUrl() {
		return masterUrl;
	}
	public void setMasterUrl(String masterUrl) {
		this.masterUrl = masterUrl;
	}

    
    
}