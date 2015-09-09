package com.earl.solrj.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;

import com.earl.solrj.SolrService;
import com.earl.solrj.query.pojo.GoodsPo;
import com.earl.solrj.query.pojo.GoodsVo;

public class BaseSolrUtilTest {

	// 直接new出来的对象，没有交给spring管理，里面的东西也无法被注入
	// solrUtil = new BaseSolrUtil();
	SolrService solrUtil = new SolrService();

	// 添加对象
	/**
	 * @throws IOException
	 * @throws SolrServerException
	 */
	@Test
	public void testAddBeanIndex() throws Exception {

		GoodsVo goods = new GoodsVo();
		List<String> list = new ArrayList<String>();

		// goods.setId("6");
		// // list.add("作用_杀虫");
		// // list.add("作用于_大田");
		// list.add("规格_100g*1包");
		// list.add("生成商_222");
		// list.add("品牌_寿禾");
		// goods.setGoodsattributes(list);
		// goods.setIshot(true);
		// goods.setGoodsname("绿色超人超甜水果玉米种子");
		// goods.setGoodspic("http:url:8080");
		// goods.setGoodsprice(10f);
		// goods.setGoodstype1("种子");
		// goods.setGoodstype2("玉米种子");
		// goods.setGoodslabel("种子_玉米_寿禾");
		// solrUtil.addBeanIndex(goods);
		//
		goods.setId("8");
		// list.add("容量_32G");
		list.add("尺寸_5.5");
		list.add("颜色_金色");
		// list.add("接口_3.0");
		list.add("生成商_魅族");
		list.add("品牌_魅族");
		goods.setGoodsattributes(list);
		goods.setIshot(true);
		goods.setGoodsname("魅蓝note");
		goods.setGoodspic("http:url:8080");
		goods.setGoodsprice(1099f);
		goods.setGoodstype1("电子产品");
		goods.setGoodstype2("手机");
		goods.setGoodslabel("魅族_魅蓝_手机");
		solrUtil.addBeanIndex(goods);

		System.out.println("添加索引成功");
	}

	// 通过id删除
	@Test
	public void testDeleteById() throws Exception {

		GoodsPo goods = new GoodsPo();
		goods.setId(1832);

		// solrUtil.deleteById(goods.getId());
	}

	// 通过查询条件删除
	@Test
	public void testDeleteByQuery() throws Exception {

		solrUtil.deleteByQuery("id:*");
		System.out.println("删除成功");
	}

//	// 测试用例   **都是在这里测试可以了才复制粘贴一个新的方法***
//	@Test
//	public void testQuery() throws Exception {
//		 List<String> list = new ArrayList<String>();
////		 list.add("颜色_金色");
//		 list.add("容量_32G");
//		GoodsVo goods = new GoodsVo();
//		 goods.setGoodsattributes(list);
////		goods.setGoodstype2("手机");
//		List<Object> beansList = solrUtil.queryWithHeightLight(goods);
//		for (Object object : beansList) {
//			System.out.println(object.toString());
//		}
//	}
	
	//根据关键字查询.
	@Test
	public void testQueryByLabel() throws Exception {
		String label = "魅蓝";
		List<Object> beansList = solrUtil.queryBean(label);
		for (Object object : beansList) {
			System.out.println(object.toString());
		}
	}

	// 根据类别查询商品属性.
	@Test
	public void testGetAttrbutes() throws Exception {
		GoodsVo goods = new GoodsVo();
		goods.setGoodstype2("手机");

		Map<String, List<String>> map = solrUtil.getAttributesByType(goods);
		java.util.Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + "-->" + map.get(key));
		}
	}

	// 查询价格区间的商品
	@Test
	public void testQueryByPrice() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("颜色_金色");
		list.add("容量_32G");
		GoodsVo goods = new GoodsVo();
		goods.setGoodsattributes(list);
		goods.setGoodstype2("U盘");
		float minPrice = 50f;
		float maxPrice = 150f;

		List<GoodsVo> beansList = solrUtil
				.queryBeans(goods, minPrice, maxPrice);
		for (Object object : beansList) {
			System.out.println(object.toString());
		}
	}

	// 根据商品最低级类别和所选择属性查询商品
	@Test
	public void testQueryByAttributes() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("颜色_金色");
		list.add("容量_32G");
		list.add("品牌_金士顿");
		GoodsVo goods = new GoodsVo();
		goods.setGoodsattributes(list);
		goods.setGoodstype2("U盘");

		List<GoodsVo> beansList = solrUtil.queryBeans(goods,
				goods.getGoodsattributes());
		for (Object object : beansList) {
			System.out.println(object.toString());
		}
	}

	// 查询热点商品
	@Test
	public void testQueryHot() throws Exception {
		GoodsVo goods = new GoodsVo();
		goods.setIshot(true);

		List<GoodsVo> beansList = solrUtil.queryBeans(goods);
		for (Object object : beansList) {
			System.out.println(object.toString());
		}
	}

	// 根据关键字查询商品
	// TODO 要加上高亮
	@Test
	public void testQueryLabel() throws Exception {
		String label = "手机";
		GoodsVo goods = new GoodsVo();
		goods.setGoodsname(label);
		goods.setGoodslabel(label);

		List<GoodsVo> beansList = solrUtil.queryBeans(goods);
		for (Object object : beansList) {
			System.out.println(object.toString());
		}
	}

	/**
	 * 根据类型查询商品
	 */ 
	@Test
	public void testQueryWithType() throws Exception {
		// String type1 = "电子产品";
		String type2 = "U盘";
		GoodsVo goods = new GoodsVo();
		// goods.setGoodstype1(type1);
		goods.setGoodstype2(type2);

		List<GoodsVo> beansList = solrUtil.queryBeans(goods);
		for (Object object : beansList) {
			System.out.println(object.toString());
		}
	}

	/**
	 * 统计父类别
	 */
	@Test
	public void testQueryWithFacet() throws Exception {
		GoodsVo goods = new GoodsVo();
		List<String> goodsTypes = solrUtil.getGoodsType(goods);
		for (Object object : goodsTypes) {
			System.out.println(object.toString());
		}
	}

	/**
	 * 根据父类别统计子类别
	 */
	@Test
	public void testQueryWithFacetType() throws Exception {
		String parentType = "电子产品";
		GoodsVo goods = new GoodsVo();
		goods.setGoodstype1(parentType);

		List<String> goodsTypes = solrUtil.getGoodsType(goods);
		for (Object object : goodsTypes) {
			System.out.println(object.toString());
		}

	}
	
}
