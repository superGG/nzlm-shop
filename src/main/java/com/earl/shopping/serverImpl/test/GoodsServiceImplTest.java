package com.earl.shopping.serverImpl.test;

import static org.junit.Assert.fail;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import com.earl.shopping.dao.GoodsDao;
import com.earl.shopping.server.GoodsService;
import com.earl.shopping.serverImpl.GoodsServiceImpl;
import com.earl.solrj.query.pojo.GoodsPo;



public class GoodsServiceImplTest {
	
	GoodsService goodsService;
	
	private GoodsDao goodsDao = null;  
	
	Mockery context = new Mockery();
	
	@Before
	public void setUp() throws Exception {
         goodsDao = context.mock(GoodsDao.class);
         
         
         goodsService = new GoodsServiceImpl(goodsDao);
     }

	@Test
	public void testGoodsServiceImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveGoods() {
		//final GoodsPo goods = new GoodsPo();
		// expectations  
		//context.checking(new Expectations() {{  
		//	oneOf (goodsDao).save(goods);  
		//}}); 

		GoodsPo goods = new GoodsPo();
		goods.setId(2);
		goods.setGoodsname("苹果6s");
		goods.setGoodsattributes("S发电公司刚");
		goods.setGoodslabel("苹果_手机");
		goods.setGoodspic("aagergsthrh");
		goods.setIshot(true);
		goods.setTypeId(4);
		goods.setGoodsprice(250f);
		goodsService.save(goods);
		
		// verify  
        //context.assertIsSatisfied();  
	}

	@Test
	public void testQueryByWord() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById(){
		
		goodsService.deleteById(1);
		
	}
	
}
