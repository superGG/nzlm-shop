package com.earl.solrj.test;

import org.junit.Test;

import com.earl.shopping.action.GoodsAction;
import com.earl.solrj.query.pojo.GoodsVo;

public class SolrActionTest {
	@Test
	public void getQuery() throws Exception {
		GoodsAction action = new GoodsAction();
		action.QueryWithFacet();
		String str = action.gettoJson();
		System.out.println(str);
	}
	
	
	@Test
	public void getHotQuery() throws Exception {
		GoodsAction action = new GoodsAction();
		
		action.QueryHotAction();
		String str = action.gettoJson();
		System.out.println(str);
	}
	
	@Test
	public void QueryLabelAction() throws Exception {
		GoodsAction action = new GoodsAction();
		action.setLabel("手机");
		action.QueryLabelAction();
		String str = action.gettoJson();
		System.out.println(str);
	}
	@Test
	public void QueryWithTypeAction() throws Exception {
		GoodsAction action = new GoodsAction();
		action.setType("手机");
		action.QueryWithTypeAction();
		String str = action.gettoJson();
		System.out.println(str);
	}
	@Test
	public void QueryWithFaceType() throws Exception {
		GoodsAction action = new GoodsAction();
		action.setParentType("手机");
		action.QueryWithFaceType();
		String str = action.gettoJson();
		System.out.println(str);
	}
	@Test
	public void GetAttrbutesAction() throws Exception {
		GoodsAction action = new GoodsAction();
		GoodsVo goodsVo = new GoodsVo();
		goodsVo.setGoodsname("手机");
		action.setGoodsVo(goodsVo);
		action.GetAttrbutesAction();
		String str = action.gettoJson();
		System.out.println(str);
	}
}
