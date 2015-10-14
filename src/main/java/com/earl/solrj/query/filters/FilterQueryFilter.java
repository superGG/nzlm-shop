package com.earl.solrj.query.filters;

import java.util.LinkedList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;

import com.earl.solrj.query.BaseQuery;
import com.earl.solrj.query.QueryDecorate;

/**
 * 查询结果约束
 * 
 * @author liufl / 2014年3月18日
 */
public class FilterQueryFilter implements QueryDecorate {

	List<String> fqs = new LinkedList<String>(); // 结果过滤查询语句列表

	/**
	 * 增加过滤语句
	 * 
	 * @param fq
	 *            过滤语句
	 * @return
	 */
	public FilterQueryFilter addFilterQuery(String fq) {
		this.fqs.add(fq);
		return this;
	}

	/**
	 * 增加过滤查询
	 * 
	 * @param fq
	 * @return
	 */
	public FilterQueryFilter addFilterQuery(BaseQuery fq) {
		this.fqs.add(fq.toString());
		return this;
	}

	public SolrQuery decorate(SolrQuery query) {
		// 注入过滤
		for (String fq : this.fqs) {
			query.addFilterQuery(fq);
		}
		return query;
	}

}
