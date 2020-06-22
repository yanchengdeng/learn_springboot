package com.maven.springboot.demo.mapper;


import com.maven.springboot.demo.entity.Shop;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ShopMapper {


    //xml  方式获取
  public Shop getShopByName(String name);




  //注解方式

  @Select("SELECT * FROM goods WHERE id = #{id}")
  //如果  代码字段 和 库中的字段不匹配，可以使用如下方式做映射，和xml 方式一样
  @Results({
      @Result(property = "name",column = "goods_name"),
      @Result(property = "info",column = "goods_info")
  })
  public Shop getById(long id);



  @Insert("INSERT INTO goods VALUES(#{id},#{name},#{info})")
  public void insert(long id,String name,String info);

    
}