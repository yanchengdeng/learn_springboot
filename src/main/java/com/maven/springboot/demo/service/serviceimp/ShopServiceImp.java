package com.maven.springboot.demo.service.serviceimp;

import com.maven.springboot.demo.service.ShopService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

import com.maven.springboot.demo.entity.Shop;
import com.maven.springboot.demo.mapper.ShopMapper;

@Service
public class ShopServiceImp  implements ShopService {

    @Resource
    ShopMapper shopMapper;

    @Override
    public Shop getShopByName( String name){
      return  shopMapper.getShopByName(name);
    }

	@Override
	public Shop getById(Long id) {
		return shopMapper.getById(id);
	}

	@Override
	public List<Shop> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserShop(Shop shop) {
		// TODO Auto-generated method stub
		
	}
    
}