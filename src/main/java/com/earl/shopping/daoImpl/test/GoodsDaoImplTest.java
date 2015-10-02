package com.earl.shopping.daoImpl.test;

import static org.junit.Assert.fail;

import org.jmock.auto.Mock;
import org.junit.Test;

import com.earl.shopping.dao.GoodsDao;
import com.earl.shopping.daoImpl.GoodsDaoImpl;
import com.earl.solrj.query.pojo.GoodsPo;

public class GoodsDaoImplTest {

	GoodsDao goodsDao = new GoodsDaoImpl();
	
  
	//TODO lala
	@Test
	public void testSave() {
		GoodsPo goods = new GoodsPo();
		goods.setId(1);
		goods.setGoodsname("苹果5s");
		goods.setGoodsattributes("的双方各得双方都");
		goods.setGoodslabel("苹果_手机");
		goods.setGoodspic("afwfregfdgdg");
		goods.setIshot(true);
		goods.setTypeId(4);
		goods.setGoodsprice(150f);
		goodsDao.save(goods);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		GoodsPo goodsPo = goodsDao.get(1);
		System.out.println(goodsPo.toString());
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByGivenCriteria() {
		fail("Not yet implemented");
	}

}
