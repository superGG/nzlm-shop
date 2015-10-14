package com.earl.solrj.query.filters;

import java.util.LinkedList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;

import com.earl.solrj.query.QueryDecorate;
import com.earl.util.Assert;

/**
 * 简单高亮显示过滤器
 * 
 * @author liufl / 2014年8月4日
 */
public class SimpleHighLightDecorate implements QueryDecorate {

	private List<String> fields = new LinkedList<String>(); // 高亮字段列表
	private String pre = "<em>"; // 高亮前缀
	private String post = "</em>"; // 高亮后缀

	/**
	 * 取出高亮字段列表
	 * 
	 * @return
	 */
	public List<String> getFields() {
		return fields;
	}

	/**
	 * 增加高亮字段
	 * 
	 * @param field
	 * @return
	 */
	public SimpleHighLightDecorate addField(String field) {
		this.fields.add(field);
		return this;
	}

	/**
	 * 设置高亮字段列表
	 * 
	 * @param fields
	 *            字段列表。不允许为空。
	 */
	public void setFields(List<String> fields) {
		Assert.notEmpty(fields, "no fields is set.");
		this.fields = fields;
	}

	/**
	 * 取出高亮区域前缀
	 * 
	 * @return
	 */
	public String getPre() {
		return pre;
	}

	/**
	 * 设置高亮区域前缀
	 * 
	 * @param pre
	 */
	public void setPre(String pre) {
		this.pre = pre;
	}

	/**
	 * 取出高亮区域后缀
	 * 
	 * @return
	 */
	public String getPost() {
		return post;
	}

	/**
	 * 设置高亮区域后缀
	 * 
	 * @param post
	 */
	public void setPost(String post) {
		this.post = post;
	}

	public SolrQuery decorate(SolrQuery query) {
		query.setHighlight(true);
		query.setHighlightSimplePost(this.post);
		query.setHighlightSimplePre(this.pre);
		for (String field : this.fields) {
			query.addHighlightField(field);
		}
		return query;
	}

}
