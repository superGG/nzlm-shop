package com.earl.solrj.query.pojo;

public class CategoryPo {

	private Long categoryid;
	private String categoryName;
	private Long categoryParent;
	private String describe;
	
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getCategoryParent() {
		return categoryParent;
	}
	public void setCategoryParent(Long categoryParent) {
		this.categoryParent = categoryParent;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
