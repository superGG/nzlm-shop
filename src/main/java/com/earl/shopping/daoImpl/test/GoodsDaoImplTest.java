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
		goods.setCategory(1);
		goods.setGoodsattributes("商品类别");
		goods.setGoodspic("123");
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
		fail("Not yet implemented");
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
