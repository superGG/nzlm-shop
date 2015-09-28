package com.earl.shopping.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.SolrServerException;

import com.earl.solrj.SolrService;
import com.earl.solrj.query.pojo.GoodsVo;
import com.earl.util.ToJson;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
public class GoodsAction extends BaseAction<GoodsVo> {

	Logger logger = LogManager.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected InputStream jsonInputStream;

	public InputStream getJsonInputStream() {
		return jsonInputStream;
	}

	private SolrService solrUtil = new SolrService();

	/**
	 * 查询商品的最低价格.
	 */
	private float minPrice;

	/**
	 * 查询商品的最高价格.
	 */
	private float maxPrice;

	/**
	 * 搜索的关键字,直接映射到goodslable,goodsname.
	 */
	private String keyWord;

	/**
	 * 查询的最低价格
	 * 
	 * @return the minPrice
	 */
	public final float getMinPrice() {
		return minPrice;
	}

	/**
	 * 查询的最高价格
	 * 
	 * @param minPrice
	 *            the minPrice to set
	 */
	public final void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	/**
	 * @return the maxPrice
	 */
	public final float getMaxPrice() {
		return maxPrice;
	}

	/**
	 * @param maxPrice
	 *            the maxPrice to set
	 */
	public final void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	// 添加索引.
	public void addGoodsAction() throws Exception {
		// 从前端获取到的Po 转成 Vo 再进行,同时保存po到数据库
		solrUtil.addBeanIndex(model);
	}

	// 通过id删除商品.
	public void deleGoodsAction() throws Exception {

		solrUtil.deleteById(model);
	}

	/**
	 * 通过id删除商品
	 * 
	 * @throws Exception
	 */
	public void deleteByIdAction() throws Exception {
		solrUtil.deleteById(model);
	}

	/**
	 * 
	 * 通过查询条件删除索引.
	 * 
	 * @throws Exception
	 * 
	 */
	// public void deleteByQuery() {
	// solrService.deleteByQuery(query);
	// }

	/**
	 * 查询价格区间的商品.
	 * 
	 * @throws Exception
	 */
	public String queryByPrice() throws Exception {
		if (minPrice != maxPrice && maxPrice > minPrice) {
			logger.debug("minPrice : "+minPrice);
			logger.debug("maxPrice : "+maxPrice);
			String jsonString = ToJson.getGson().toJson(
					solrUtil.queryBeans(model, minPrice, maxPrice));
			logger.debug("jsonString : "+jsonString);
			jsonInputStream = new ByteArrayInputStream(
					jsonString.getBytes("utf-8"));
		}
		return "done";
	}

	/**
	 * @author 宋文光.
	 * @return String
	 * @throws Exception
	 */
	public String queryByAttributes() throws Exception {
		if (model.getGoodsattributes() != null) {
			logger.debug("godosattributes : "+model.getGoodsattributes());
			String jsonString = ToJson.getGson().toJson(
					solrUtil.queryBeans(model, model.getGoodsattributes()));
			logger.debug("jsonString : "+jsonString);
			jsonInputStream = new ByteArrayInputStream(
					jsonString.getBytes("utf-8"));
		}
		return "done";
	}

	/**
	 * 根据商品类型查询商品. List<GoodsVo>
	 * 
	 * @author 宋文光.
	 * @return
	 * @throws IOException
	 * @throws SolrServerException
	 * 
	 */
	public String queryByType() throws SolrServerException, IOException {
		String jsonString = null;
		if (model.getGoodstype3() != null) {
			logger.debug("type3 : "+model.getGoodstype3());
			jsonString = ToJson.getGson().toJson(
					solrUtil.queryBeans(model, model.getGoodstype3()));
			logger.debug("jsonString : "+jsonString);
		} else if (model.getGoodstype2() != null) {
			logger.debug("type2 : "+model.getGoodstype2());
			jsonString = ToJson.getGson().toJson(
					solrUtil.queryBeans(model, model.getGoodstype2()));
			logger.debug("jsonString : "+jsonString);
		}
		jsonInputStream = new ByteArrayInputStream(
				jsonString.getBytes("utf-8"));
		return "done";
	}

	/**
	 * 查询热点商品.
	 * 
	 * @author 宋文光.
	 * 
	 * @return
	 * 
	 * @throws IOException
	 * @throws SolrServerException
	 * 
	 */
	public String queryHot() throws SolrServerException, IOException {
		model.setIshot(true);
		String jsonString = ToJson.getGson().toJson(solrUtil.queryBeans(model));
		logger.debug(jsonString);
		jsonInputStream = new ByteArrayInputStream(jsonString.getBytes("utf-8"));
		return "done";
	}

	/**
	 * 根据关键字查询商品. 返回高亮集合. List<Object>.
	 * 
	 * @author 黄祥谦.
	 * 
	 * @return List<GoodsVo> 匹配goodsname,goodslable属性
	 * 
	 * @throws IOException
	 * @throws SolrServerException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * 
	 */
	public String queryKeyWord() throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, SolrServerException, IOException {
			logger.debug("keyWord : "+keyWord);
			String jsonString = ToJson.getGson().toJson(
					solrUtil.queryBean(keyWord));
			logger.debug("jsonString : " + jsonString);
			jsonInputStream = new ByteArrayInputStream(
					jsonString.getBytes("utf-8"));
			return "done";
	}

	/**
	 * 
	 * 通过查询条件删除索引.
	 * 
	 * @throws Exception
	 * 
	 */
	// public void deleteByQuery() {
	// solrService.deleteByQuery(query);
	// }
	
	/**
	 * 根据类别查询商品的属性. 赋值给Map<String,List<String>>
	 * 
	 * @throws Exception
	 */
	public String getAttrbutes() throws Exception {
			logger.debug("type2 : "+model.getGoodstype2());
			logger.debug("type3 : "+model.getGoodstype3());
			String jsonString = ToJson.getGson().toJson(
					solrUtil.getAttributesByType(model));
			logger.debug("jsonString : "+jsonString);
			jsonInputStream = new ByteArrayInputStream(
					jsonString.getBytes("utf-8"));
		return "done";
	}

	/**
	 * 获取所有类别.
	 * 
	 * @author 黄祥谦.
	 * @return json数组，type1,type2,type3
	 * 
	 * @throws IOException
	 * @throws SolrServerException
	 */
	public String getCategory() throws SolrServerException, IOException {
		String jsonString = ToJson.getGson().toJson(solrUtil.getCategory());
		logger.debug(jsonString);
		jsonInputStream = new ByteArrayInputStream(jsonString.getBytes("utf-8"));
		return "done";
	}
}
