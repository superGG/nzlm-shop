package com.earl.shopping.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;

import com.earl.solrj.SolrService;
import com.earl.solrj.query.pojo.GoodsPo;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 3293435262298029608L;

	protected InputStream jsonInputStream;


	public InputStream getJsonInputStream() {
		return jsonInputStream;
	}
    
	
	/**
	 * 商品的List集合.
	 */
	private List<GoodsVo> GoodsVoList;

	private SolrService solrUtil;
	
	private GoodsVo goodsVo;

	private GoodsPo goodsPo;
	
	//查询的条件
	private List<String> list;

	

	// 查询语句.
	private SolrQuery queryStatement;
	
	//查询的结果集合.
	private Map<String,List<String>> map;

	// 商品的属性.
	private List<String> str;
	// 查询商品的最低价格
	private float minPrice;
	// 查询商品的最高价格.
	private float maxPrice;
	
	//商品类型
	private String type;
	//商品关键字.
	private String label;
	//统计父类类别的集合.
	private List<String> goodsTypes;
	//统计该类别下的子类.
	private String parentType;
	//高亮查询结果集.
	private List<Object> lightList;
	//String数据封装
	private String toJson;
	
	

	
	
	
	/**
	 * @return the String
	 */
	public final String gettoJson() {
		return toJson;
	}

	/**
	 * @param String the String to set
	 */
	public final void settoJson(String toJson) {
		this.toJson = toJson;
	}

	/**
	 * @return the lightList
	 */
	public final List<Object> getLightList() {
		return lightList;
	}

	/**
	 * @param lightList the lightList to set
	 */
	public final void setLightList(List<Object> lightList) {
		this.lightList = lightList;
	}

	/**
	 * @return the goodsTypes
	 */
	public final List<String> getGoodsTypes() {
		return goodsTypes;
	}

	/**
	 * @param goodsTypes the goodsTypes to set
	 */
	public final void setGoodsTypes(List<String> goodsTypes) {
		this.goodsTypes = goodsTypes;
	}

	/**
	 * @return the parentType
	 */
	public final String getParentType() {
		return parentType;
	}

	/**
	 * @param parentType the parentType to set
	 */
	public final void setParentType(String parentType) {
		this.parentType = parentType;
	}

	/**
	 * @return the label
	 */
	public final String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public final void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the type
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the list
	 */
	public final List<String> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public final void setList(List<String> list) {
		this.list = list;
	}
	/**
	 * @return the map
	 */
	public final Map<String, List<String>> getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public final void setMap(Map<String, List<String>> map) {
		this.map = map;
	}

	/**
	 * @return the queryStatement
	 */
	public final SolrQuery getQueryStatement() {
		return queryStatement;
	}

	/**
	 * @param queryStatement
	 *            the queryStatement to set
	 */
	public final void setQueryStatement(SolrQuery queryStatement) {
		this.queryStatement = queryStatement;
	}

	/**
	 * 
	 * @return the str
	 */
	public final List<String> getStr() {
		return str;
	}

	/**
	 * 查询的商品的属性.
	 * 
	 * @param str
	 *            the str to set
	 */
	public final void setStr(List<String> str) {
		this.str = str;
	}

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

	/**
	 * @return the serialversionuid
	 */
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}

	

	/**
	 * 获取商品的list集合.
	 * 
	 * @return the goodsVoList
	 */
	public final List<GoodsVo> getGoodsVoList() {
		return GoodsVoList;
	}

	/**
	 * 设置商品的List集合.
	 * 
	 * @param goodsVoList
	 *            the goodsVoList to set
	 */
	public final void setGoodsVoList(List<GoodsVo> goodsVoList) {
		GoodsVoList = goodsVoList;
	}

	public GoodsPo getGoodsPo() {
		return goodsPo;
	}

	public void setGoodsPo(GoodsPo goodsPo) {
		this.goodsPo = goodsPo;
	}

	public GoodsVo getGoodsVo() {
		return goodsVo;
	}

	public void setGoodsVo(GoodsVo goodsVo) {
		this.goodsVo = goodsVo;
	}

	public SolrService getSolrUtil() {
		return solrUtil;
	}

	public void setSolrUtil(SolrService solrUtil) {
		this.solrUtil = solrUtil;
	}

	// 下面填写业务逻辑

	public String lala() throws UnsupportedEncodingException {

		System.out.println("dodo");
		String json = "dodo1";
		jsonInputStream = new ByteArrayInputStream(json.getBytes("utf-8"));

		return "done";
	}

	// 添加索引.
	public void addGoodsAction() throws Exception {
		// TODO 从前端获取到的Po 转成 Vo 再进行,同时保存po到数据库
		solrUtil.addBeanIndex(goodsVo);
	}

	// 通过id删除商品.
	public void deleGoodsAction() throws Exception {

		solrUtil.deleteById(goodsVo);
	}

	/**
	 * 通过id删除商品
	 * 
	 * @throws Exception
	 */
	public void deleteByIdAction() throws Exception {
		solrUtil.deleteById(goodsVo);
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
	 * 根据类别查询商品的属性.
	 * 赋值给Map<String,List<String>>
	 * @throws Exception
	 */
	public void GetAttrbutesAction () throws Exception {
		if (goodsVo != null ) {
			 map = solrUtil.getAttributesByType(goodsVo);
			 toJson = ToJson.getGson().toJson(map);
		} else {
			return ;
		}
	}
	
	/**
	 * 查询价格区间的商品.
	 * @throws Exception
	 */
	public void QueryByPriceAction() throws Exception {
		if(list != null ) 
			goodsVo.setGoodsattributes(list);
		else {
			return;
		}
		if (minPrice != maxPrice && maxPrice > minPrice) {
			GoodsVoList = solrUtil.queryBeans(goodsVo, minPrice,
					maxPrice);
			toJson = ToJson.getGson().toJson(GoodsVoList);
		}  else {
			return ;
		}
	}
	/**
	 * 根据商品类型查询商品.
	 * List<GoodsVo>
	 * @throws Exception
	 */
	public void QueryWithTypeAction() throws Exception {
		if (type != null ) {
			goodsVo.setGoodstype2(type);
			GoodsVoList = solrUtil.queryBeans(goodsVo);
			toJson = ToJson.getGson().toJson(GoodsVoList);
		} else {
			return ;
		}
	}
	
	/**
	 * 查询热点商品.
	 * @throws Exception
	 */
	public void QueryHotAction() throws Exception {
		goodsVo.setIshot(true);
		GoodsVoList = solrUtil.queryBeans(goodsVo);
		toJson = ToJson.getGson().toJson(GoodsVoList);
	}
	
	/**
	 * 根据关键字查询商品.
	 * 返回高亮集合.
	 * List<Object>.
	 * @throws Exception
	 */
	public void QueryLabelAction() throws Exception {
		if (label != null ) {
			lightList = solrUtil.queryBean(label);
			toJson = ToJson.getGson().toJson(lightList);
		} else {
			return ;
		}
	}
    
	/**
	 * 统计父类别.
	 * @throws Exception
	 */
	public void QueryWithFacet() throws Exception {
		goodsVo = new GoodsVo();
		goodsTypes = solrUtil.getGoodsType(goodsVo);
		toJson = ToJson.getGson().toJson(goodsTypes);
	}
	
	/**
	 * 根据父类别统计子类别.
	 * @throws Exception
	 */
	public void QueryWithFaceType() throws Exception {
		if (parentType != null ) 
			goodsVo.setGoodstype1(parentType);
		goodsTypes = solrUtil.getGoodsType(goodsVo);
		toJson = ToJson.getGson().toJson(goodsTypes); 
	}
	

}