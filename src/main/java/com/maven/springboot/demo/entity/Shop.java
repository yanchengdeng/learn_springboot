package com.maven.springboot.demo.entity;

/**
 * 这里的实体类 和 数据库做映射
 */


public class Shop {
    private Long id;
    private String name;
    private String info;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String price) {
		this.info = price;
	}
	
	


    
    
}