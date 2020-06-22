package com.maven.springboot.demo.service.serviceimp;

import com.maven.springboot.demo.service.ShopService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Synchronized;
import sun.awt.www.content.audio.x_aiff;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.maven.springboot.demo.entity.Shop;
import com.maven.springboot.demo.mapper.ShopMapper;

@Service
public class ShopServiceImp  implements ShopService {

	private final static Logger logger = LoggerFactory.getLogger(ShopServiceImp.class);

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


	/**
	 * 直接抛出异常，则不会插入成功，事务功能生效
	 * 注意:
	 * 1.如果只是在方法中 抛出手动抛出一个 `SQLException` 来模拟实际中操作数据库发生的异常，数据库仍然操作成功
	 *因为 Spring Boot 默认的事务规则是遇到运行异常（RuntimeException）和程序错误（Error）才会回滚
	 所有如果需要事务回滚的话，务必指定回滚异常

	 2.  如果使用try catch  ,则还会执行数据库插入，所以在有需要事务处理的地方，一定注意，不能让异常被"吃掉"

	 3.事务和 异步锁范围问题
	 方法上是加了事务的，那么也就是说，在执行该方法开始时，事务启动，执行完了后，事务关闭。但是 synchronized 没有起作用，其实根本原因是因为事务的范围比锁的范围大。
	 也就是说，在加锁的那部分代码执行完之后，锁释放掉了，但是事务还没结束，此时另一个线程进来了，事务没结束的话，
	 第二个线程进来时，数据库的状态和第一个线程刚进来是一样的。即由于mysql Innodb引擎的默认隔离级别是可重复读（在同一个事务里，SELECT的结果是事务开始时时间点的状态）
	 ，线程二事务开始的时候，线程一还没提交完成，导致读取的数据还没更新。第二个线程也做了插入动作，导致了脏数据。  
	 这个问题可以避免，第一，把事务去掉即可（不推荐）；第二，在调用该 service 的地方加锁，保证锁的范围比事务的范围大即可。

	
	 */
	@Override
	@Transactional(rollbackFor = SQLException.class) //添加指定回滚异常  才生效
	public  void inserShop(Shop shop) throws SQLException {
		// try{
			shopMapper.insert(shop.getId(),shop.getName(),shop.getInfo());
			throw new SQLException("数据库插入失败");
		// }catch(Exception e){
		// 	logger.error("添加商品异常{}", e.getMessage());
		// }
	}
    
}