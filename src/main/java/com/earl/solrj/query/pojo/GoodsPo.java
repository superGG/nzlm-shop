package com.earl.solrj.query.pojo;

import java.util.List;

/**
 * 
 */
public class GoodsPo {

	
	private Integer id;
	
	// 商品名称
	private String goodsname;
	
	// 商品属性
	private List<String> goodsattributes;
	
	// 商品价格
	private Float goodsprice;
	
	// 商品图片
	private String goodspic;
	
	// 该商品是否是热点
	private boolean ishot;

	// 商品标签(关键字)
	private String goodslabel;

	public Integer getId() {
		return id;
	}

	public String getGoodslabel() {
		return goodslabel;
	}

	public void setGoodslabel(String goodslabel) {
		this.goodslabel = goodslabel;
	}

	public String getGoodspic() {
		return goodspic;
	}

	public void setGoodspic(String goodspic) {
		this.goodspic = goodspic;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public List<String> getGoodsattributes() {
		return goodsattributes;
	}

	public void setGoodsattributes(List<String> goodsattributes) {
		this.goodsattributes = goodsattributes;
	}

	public Float getGoodsprice() {
		return goodsprice;
	}

	public void setGoodsprice(Float goodsprice) {
		this.goodsprice = goodsprice;
	}

	public boolean isIshot() {
		return ishot;
	}

	public void setIshot(boolean ishot) {
		this.ishot = ishot;
	}

}
