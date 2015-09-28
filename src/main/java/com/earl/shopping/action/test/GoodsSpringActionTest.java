package com.earl.shopping.action.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import com.earl.shopping.action.GoodsAction;
import com.earl.solrj.query.pojo.GoodsPo;
import com.earl.solrj.query.pojo.GoodsVo;

public class GoodsSpringActionTest extends StrutsJUnit4TestCase<GoodsAction>{

	@Test 
	public void testGetCategory() throws Exception {
		 String res=executeAction("/goods_getCategory.action");
		 System.out.println(res.getBytes().toString()); 
		 System.out.println(res); 
	}
}
