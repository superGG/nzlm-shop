package com.earl.shopping.action.test;

import static org.junit.Assert.fail;

import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import com.earl.solrj.query.pojo.GoodsPo;

public class GoodsSpringActionTest extends StrutsJUnit4TestCase<GoodsPo>{

	@Test
	public void testAddRandomUser() throws Exception{
		 request.addParameter("id", "1");  
	        String res=executeAction("/goods_lala.action");  
	        System.out.println(res); 
	        
//	        request.setParameter("carInfo",
//	                "{\"carType\":\"三厢\""
//	                + ",\"carBrand\":\"宝马\""
//	                + ",\"carVersion\":\"x86\""
//	                + ",\"carPrice\":\"120000\""
//	                + ",\"carInsurance\":\"1200\""
//	                + ",\"carGear\":\"1.4自动挡\""
//	                + ",\"carCarriage\":\"三厢\""
//	                + ",\"carState\":\"0\""
//	                + "}");
	}

	@Test
	public void testAddCustomUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testLockUpUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPropCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUnReadMessages() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoginSystem() {
		fail("Not yet implemented");
	}

	@Test
	public void testPropNumberIncre() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnLockNumberDecre() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFriendsInfo() {
		fail("Not yet implemented");
	}

}
