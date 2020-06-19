package com.maven.springboot.demo.control;

import java.math.BigDecimal;

import javax.annotation.Resource;

import com.maven.springboot.demo.entity.Shop;
import com.maven.springboot.demo.service.ShopService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMyBatisController {


    @Resource
    ShopService shopService;



    //该方式 为 xml  配置  

    @GetMapping("/shop/names/{name}")
    public Shop getShopByName(@PathVariable String name){

        return shopService.getShopByName(name);
    }


    // 一下为  注解方式实现
    @GetMapping("/shop/ids/{id}")
    public Shop getById(@PathVariable Long id){
        return shopService.getById(id);
    }
    
}