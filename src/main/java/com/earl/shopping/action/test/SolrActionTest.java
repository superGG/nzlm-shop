package com.earl.shopping.action.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.earl.shopping.action.GoodsAction;
import com.earl.solrj.query.pojo.GoodsVo;

public class SolrActionTest {
	@Test
	public void getQuery() throws Exception {
		GoodsAction action = new GoodsAction();
		action.QueryWithFacet();
		String str = action.getJndata();
		System.out.println(str);
	}
	
	
	@Test
	public void getHotQuery() throws Exception {
		GoodsAction action = new GoodsAction();
		
		action.QueryHotAction();
		String str = action.getJndata();
		System.out.println(str);
	}
	
	@Test
	public void QueryKeyWordAction() throws Exception {
		GoodsAction action = new GoodsAction();
		action.setKeyWord("u盘");
		action.QueryKeyWordAction();
		String str = action.getJndata();
		System.out.println(str);
	}
	@Test
	public void QueryWithTypeAction() throws Exception {
		GoodsAction action = new GoodsAction();
		action.setType2("手机");
		action.QueryWithTypeAction();
		String str = action.getJndata();
		System.out.println(str);
	}
	@Test
	public void QueryWithFaceType() throws Exception {
		GoodsAction action = new GoodsAction();
		action.setParentType("电子产品");
		action.QueryWithFaceType();
		String str = action.getJndata();
		System.out.println(str);
	}
	
	@Test
	public void GetAttrbutesAction() throws Exception {
		GoodsAction action = new GoodsAction();
		GoodsVo goodsVo = new GoodsVo();
		action.setType2("U盘");
		action.setGoodsVo(goodsVo);
		action.GetAttrbutesAction();
		String str = action.getJndata();
		System.out.println(str);
	}
	
	@Test
	public void QueryByPriceAction() throws Exception {
		GoodsAction action = new GoodsAction();
		GoodsVo goodsVo = new GoodsVo();
		List<String> list = new ArrayList<String>();
		list.add("颜色_金色");
		list.add("容量_32G");
		action.setList(list);
		action.setMinPrice(50f);
		action.setMaxPrice(150f);
		action.setType2("U盘");
		action.setGoodsVo(goodsVo);
		action.QueryByPriceAction();
		String str = action.getJndata();
		System.out.println(str);
	}

	@Test
	public void QueryByAttributesAction() throws Exception {
		GoodsAction action = new GoodsAction();
		GoodsVo goodsVo = new GoodsVo();
		List<String> list = new ArrayList<String>();
		list.add("颜色_金色");
		list.add("容量_32G");
		list.add("品牌_金士顿");
		action.setList(list);
		action.setType2("U盘");
		action.setGoodsVo(goodsVo);
		action.QueryByAttributesAction();
		String str = action.getJndata();
		System.out.println(str);
	}
	
}
