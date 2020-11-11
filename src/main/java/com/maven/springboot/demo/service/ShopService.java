package com.maven.springboot.demo.service;




import java.sql.SQLException;
import java.util.List;

import com.maven.springboot.demo.entity.Shop;

public interface ShopService {

    Shop getShopByName(String name);

    Shop getById(Long id);

    List<Shop> findAll();

    void insertShop(Shop shop) throws SQLException;
}