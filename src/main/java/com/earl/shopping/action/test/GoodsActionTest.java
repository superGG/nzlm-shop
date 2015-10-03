package com.earl.shopping.action.test;

import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.StrutsJUnit4TestCase;
import org.junit.Test;

import com.earl.shopping.action.GoodsAction;

public class GoodsActionTest extends StrutsJUnit4TestCase<GoodsAction> {

	Logger logger = LogManager.getLogger(this.getClass());

	@Test
	public void testAddGoodsAction() throws UnsupportedEncodingException, ServletException {
		request.addParameter("goodsname", "U盘");
		request.addParameter("goodsattributes", "品牌_魅蓝;颜色_蓝色;");
		request.addParameter("goodsprice", "23");
		request.addParameter("goodspic", "http:8080/solr/slkdjfsdlkfj");
		request.addParameter("ishot", "true");
		request.addParameter("goodslabel", "U盘");
		request.addParameter("typeId", "5");
		logger.debug("pathInfo "+request.getPathInfo());
		String res = executeAction("/goods_addGoods.action");
	}

	@Test
	public void testDeleGoodsAction() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByIdAction() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAttrbutes() throws UnsupportedEncodingException, ServletException {
		request.addParameter("goodstype2", "U盘");
//		request.addParameter("goodstype3", "u盘");
		logger.debug("pathInfo "+request.getPathInfo());
		String res = executeAction("/goods_getAttrbutes.action");
	}

	@Test
	public void testQueryByPrice() throws UnsupportedEncodingException, ServletException {
		request.addParameter("minPrice", "12.0");
		request.addParameter("maxPrice", "16.0");
		logger.debug("pathInfo "+request.getPathInfo());
		String res = executeAction("/goods_queryByPrice.action");
	}

	@Test
	public void testQueryByAttributes() throws UnsupportedEncodingException, ServletException {
		request.addParameter("goodsattributes", "颜色_金色");
		request.addParameter("goodsattributes", "容量_32G");
		request.addParameter("goodsattributes", "品牌_金士顿");
		logger.debug("RequestURI "+request.getRequestURI());
		String res = executeAction("/goods_queryByAttributes.action");
	}

	@Test
	public void testQueryByType() throws UnsupportedEncodingException, ServletException {
//		request.addParameter("goodstype2", "u盘");
		request.addParameter("goodstype3", "u盘");
		logger.debug("pathInfo "+request.getPathInfo());
		String res = executeAction("/goods_queryByType.action");
	}

	@Test
	public void testQueryHot() throws UnsupportedEncodingException, ServletException {
		logger.debug(request.getPathInfo());
		String res = executeAction("/goods_queryHot.action");
	}

	@Test
	public void testQueryKeyWord() throws UnsupportedEncodingException,
			ServletException {

		request.addParameter("keyWord", "u盘");
		logger.debug(request.getPathInfo());
		String res = executeAction("/goods_queryKeyWord.action");

	}

	@Test
	public void testGetCategory() throws UnsupportedEncodingException,
			ServletException {
		String res = executeAction("/goods_getCategory.action");
	}

}
