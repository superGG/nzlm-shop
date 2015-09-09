package com.earl.solrj.query.pojo;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 
 */
public class GoodsVo {

	@Field
	private String id;

	// 商品名称
	@Field
	private String goodsname;

	// 商品属性
	@Field
	private List<String> goodsattributes;

	// 商品价格
	@Field
	private Float goodsprice;

	// 商品图片
	@Field
	private String goodspic;

	// 该商品是否是热点
	@Field
	private boolean ishot;

	// 商品标签(关键字)
	@Field
	private String goodslabel;

	// 1级类别
	@Field
	private String goodstype1;

	// 2级类别
	@Field
	private String goodstype2;

	// 3级类别
	@Field
	private String goodstype3;
	
	
	public GoodsVo() {
		super();
	}

	public String getId() {
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

	public void setId(String id) {
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

	public String getGoodstype1() {
		return goodstype1;
	}

	public void setGoodstype1(String goodstype1) {
		this.goodstype1 = goodstype1;
	}

	public String getGoodstype2() {
		return goodstype2;
	}

	public void setGoodstype2(String goodstype2) {
		this.goodstype2 = goodstype2;
	}

	public String getGoodstype3() {
		return goodstype3;
	}

	public void setGoodstype3(String goodstype3) {
		this.goodstype3 = goodstype3;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", goodsname=" + goodsname
				+ ", goodsattributes=" + goodsattributes + ", goodsprice="
				+ goodsprice + ", goodspic=" + goodspic + ", ishot=" + ishot
				+ ", goodslabel=" + goodslabel + ", goodstype1=" + goodstype1
				+ ", goodstype2=" + goodstype2 + ", goodstype3=" + goodstype3
				+ "]";
	}
	
	
}
