package com.maven.springboot.demo.service;




import java.util.List;

import com.maven.springboot.demo.entity.Shop;

public interface ShopService {

    Shop getShopByName(String name);

    Shop getById(Long id);

    List<Shop> findAll();

    void inserShop(Shop shop);
}