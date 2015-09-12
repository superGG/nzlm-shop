package com.earl.shopping.action.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.earl.shopping.action.GoodsAction;
import com.earl.solrj.query.pojo.GoodsVo;

public class SolrActionTest {	
	
	//查询热点商品测试类
	@Test
	public void getHotQuery() throws Exception {
		GoodsAction action = new GoodsAction();
		
		action.QueryHotAction();
		String str = action.getJndata();
		System.out.println(str);
	}
	
	//根据关键字查询商品测试类
	@Test
	public void QueryKeyWordAction() throws Exception {
		GoodsAction action = new GoodsAction();
		action.setKeyWord("u盘");
		action.QueryKeyWordAction();
		String str = action.getJndata();
		System.out.println(str);
	}
	
	//根据类别查询商品测试类
	@Test
	public void QueryByTypeAction() throws Exception {
		GoodsAction action = new GoodsAction();
		action.setType2("手机");
		action.QueryByTypeAction();
		String str = action.getJndata();
		System.out.println(str);
	}
	
	//统计类别测试类
	@Test
	public void GetTypeAction() throws Exception {
		GoodsAction action = new GoodsAction();
		action.setType2("U盘");
		action.GetTypeAction();
		String str = action.getJndata();
		System.out.println(str);
	}
	
	//获取某类别商品的属性名跟属性值
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
	
	//根据价格区间查询商品
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

	//根据商品属性查询商品测试类
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
