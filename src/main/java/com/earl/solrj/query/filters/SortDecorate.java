package com.earl.solrj.query.filters;

import java.util.LinkedList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;

import com.earl.solrj.query.QueryDecorate;
import com.earl.util.Assert;


/**
 * 排序设置过滤器
 * @author liufl / 2014年3月18日
 */
public class SortDecorate implements QueryDecorate {

	private List<SortClause> sortClauses = new LinkedList<SortClause>(); // 排序方式列表

	/**
	 * 增加排序方式。先加入的优先级较高。
	 * @param sortField
	 * @return
	 */
	public SortDecorate addSortField(SortClause sortField) {
		this.sortClauses.add(sortField);
		return this;
	}

	public SolrQuery decorate(SolrQuery query) {
		Assert.notNull(query, "can not filter null query");
		return query.setSorts(this.sortClauses);
	}

}
