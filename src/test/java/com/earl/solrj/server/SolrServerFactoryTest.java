package com.earl.solrj.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.TermsResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.NamedList;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.solrj.query.pojo.GoodsPo;
import com.earl.solrj.query.pojo.GoodsVo;

/**
 * @author liufl
 * @date 2014年3月18日
 * @email hawkdowen@126.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test_appCtx.xml")
public class SolrServerFactoryTest {

	@Autowired
	private SolrServerConfiguration masterServerConf;
	@Autowired
	private SolrServerFactory masterFactory;
	@Autowired
	private SolrServerConfiguration slavesServerConf;
	@Autowired
	private SolrServerFactory slavesFactory;

	@Test
	@Ignore
	public void test() {
//		assertNotNull(masterServerConf);
//		assertNotNull(slavesServerConf);
	}

	@Test
	@Ignore
	public void testFactory() {
		assertNotNull(masterFactory);
		SolrClient solrServer = this.masterFactory.getUpdateSolrClient();
		assertTrue(solrServer instanceof ConcurrentUpdateSolrClient);
		solrServer = this.masterFactory.getUpdateSolrClient(true);
		assertTrue(solrServer.getClass().equals(HttpSolrClient.class));
		solrServer = this.masterFactory.getQuerySolrClient();
		assertTrue(solrServer.getClass().equals(HttpSolrClient.class));
		assertNotNull(slavesFactory);
		solrServer = this.slavesFactory.getUpdateSolrClient();
		assertTrue(solrServer == null);
		solrServer = this.slavesFactory.getUpdateSolrClient(true);
		assertTrue(solrServer == null);
		solrServer = this.slavesFactory.getQuerySolrClient();
		assertTrue(solrServer instanceof LBHttpSolrClient);
	}
	
	@Test
	public void testAddIndex() throws IOException, SolrServerException{
		SolrClient updateClient = this.masterFactory.getUpdateSolrClient();
		SolrInputDocument solrInputDocument = new SolrInputDocument();
		GoodsVo goods = new GoodsVo();
		goods.setId("1001");
//		solrInputDocument.addField("description", goods.getDescription());
		solrInputDocument.addField("id", goods.getId());
		UpdateResponse response = updateClient.add(solrInputDocument);
		String requestUrl = response.getRequestUrl();
		System.out.println(requestUrl);
		NamedList<Object> response2 = response.getResponse();
		int status = response.getStatus();
		
		updateClient.commit();
	}
	@Test
	public void testAddBeanIndex() throws IOException, SolrServerException{
		SolrClient updateClient = this.masterFactory.getUpdateSolrClient();
		GoodsVo goods = new GoodsVo();
		goods.setId("1002");
//		goods.setDescription("describemcw");
		UpdateResponse response = updateClient.addBean(goods);
		String requestUrl = response.getRequestUrl();
		System.out.println(requestUrl);
		NamedList<Object> response2 = response.getResponse();
		int status = response.getStatus();
		
		updateClient.commit();
	}
	
	@Test
	//查询函数，并且将结果封装成对象
	public void testQuery() throws SolrServerException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		SolrClient queryClient = this.masterFactory.getQuerySolrClient();
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("id: *");
		
		QueryResponse query = queryClient.query(solrQuery);
		
		Map<String, Object> debugMap = query.getDebugMap();
		TermsResponse termsResponse = query.getTermsResponse();
		SolrDocumentList results = query.getResults();
		GoodsPo goods = null;
		for (SolrDocument solrDocument : results) {
			goods = new GoodsPo();
			BeanMap beanMap = new BeanMap(goods);
			 Iterator<Object> iterator = beanMap.keySet().iterator();
			while(iterator.hasNext()) {
				String pro = (String) iterator.next();
				//得到solrDocument中指定的属性值
				String value = (String)solrDocument.get(pro);
				if(value != null){
					Method writeMethod = beanMap.getWriteMethod(pro);
					//如果value值为空，报空异常
					writeMethod.invoke(goods, value);
				}
				System.out.println(pro);
			}
			System.out.println(goods);
			System.out.println(solrDocument);
		}
		
		System.out.println("dd");
		
	}
	
	@Test
	public void testDeleteIndex() throws SolrServerException, IOException{
		SolrClient updateClient = this.masterFactory.getUpdateSolrClient(true);
		
//		updateClient.deleteById("1001");
		
		updateClient.deleteByQuery("description: describemc");
		
		updateClient.commit();
	}
	//update Index
	@Test
	public void testUpdateIndex() throws IOException, SolrServerException {
		
		SolrClient updateSolrClient = this.masterFactory.getUpdateSolrClient();
		
		GoodsVo goods = new GoodsVo(); 
		goods.setId("1002");
//		goods.setDescription("describemcw12");
		UpdateResponse response = updateSolrClient.addBean(goods);
		String requestUrl = response.getRequestUrl();
		System.out.println(requestUrl);
		NamedList<Object> response2 = response.getResponse();
		int status = response.getStatus();
		
		updateSolrClient.commit();
	}
	
	public void queryHeight(){
		
		
		
		
		
		
	}
	
}
