package com.maven.springboot.demo.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户实体类")
public class User {

    @ApiModelProperty(value = "用户名",dataType = "String",required = true)
    private String name;
    @ApiModelProperty(value = "电话",dataType = "String",required = true)
    private String phone;
    @ApiModelProperty(value = "年龄",dataType = "integer",required = false)  // example = "1" 解决 字段为 int 型的默认值转换错误
    private Integer age;
    @ApiModelProperty(value = "地址",dataType = "String",required = true)
    private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(String name) {
		this.name = name;
	}

	public User(){
		
	}
    
}