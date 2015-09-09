package com.earl.solrj.server;

import java.net.MalformedURLException;
import java.util.Iterator;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttpSolrClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.earl.solrj.server.SolrServerConfiguration.Type;
import com.earl.util.Assert;

/**
 * SolrJ API SolrServer工厂类
 * @author liufl / 2014年3月16日
 */
public class SolrServerFactory {

	private Logger log = LoggerFactory.getLogger(getClass());

	private SolrClient httpSolrClient; // 通用SolrServer
	private SolrClient updateSolrClient; // 更新用SolrServer
	private boolean updateSolrClientBuilt; // 更新用SolrServer生成标志
	private SolrClient querySolrClient; // 查询用SolrServer
	private boolean querySolrClientBuilt; // 查询用SolrServer生成标志

	
	private SolrServerConfiguration conf; // 配置信息
	
	public SolrServerFactory(){
		
		conf = new SolrServerConfiguration();
	}

	/**
	 * SolrServer 配置
	 * @return
	 */
	public SolrServerConfiguration getConf() {
		return conf;
	}

	/**
	 * 设置SolrServer配置
	 * @param conf
	 */
	public void setConf(SolrServerConfiguration conf) {
		validConf(conf); // 校验
		this.conf = conf;
	}

	/**
	 * 获取此solr core的更新用SolrServer实例<br/>
	 * 如果有可能，优先返回ConcurrentUpdateSolrServer
	 * @return
	 */
	public SolrClient getUpdateSolrClient() {
		if (!this.updateSolrClientBuilt) {
			this.buildUpdateSolrClient();
		}
		return this.updateSolrClient;
	}

	/**
	 * 获取此solr core的更新用SolrClient实例
	 * @param standard true:HttpSolrClient;false:与getUpdateSolrClient()行为相同
	 * @return
	 */
	public SolrClient getUpdateSolrClient(boolean standard) {
		if (!this.updateSolrClientBuilt) {
			this.buildUpdateSolrClient();
		}
		//是否获取标准的Client,是则使用httpClient，否则使用ConcurrentUpdateClient
		return standard ? this.httpSolrClient : this.updateSolrClient;
	}

	/**
	 * 获取此solr core的查询用SolrServer实例
	 * @return
	 */
	public SolrClient getQuerySolrClient() {
		if (!this.querySolrClientBuilt) {
			this.buildQuerySolrClient();
		}
		return this.querySolrClient;
	}

	private void validConf() {
		if (this.conf == null) {
			throw new IllegalStateException("not configed!");
		}
	}

	private void validConf(SolrServerConfiguration conf) {
		Assert.notNull(conf, "conf is null"); // 对象不是null
		Assert.notEmpty(conf.getServerUrls(), "no serverUrl is provided"); // 至少提供一条Server地址
	}

	/**
	 * 是否单服务器节点访问
	 * @return
	 */
	private boolean isSingle() {
		return this.conf.getServerUrls().size() == 1;
	}

	/**
	 * 建造更新用Server
	 */
	private void buildUpdateSolrClient() {
		this.validConf(); // 必须是已配置的对象
		if (this.isSingle()) { // 必须是单服务器节点
			Type type = this.conf.getType();
			// 标准SolrServer
			if (type.accept(HttpSolrClient.class)) {
				this.httpSolrClient = this.buildHttpSolrClient();
			}
			// 更新用SolrServer
			if (type.accept(ConcurrentUpdateSolrClient.class)) {
				this.updateSolrClient = this.buildConcurrentUpdateSolrClient();
			} else if (type.accept(HttpSolrClient.class)) {
				this.updateSolrClient = this.httpSolrClient;
			}
		}
		this.updateSolrClientBuilt = true;
	}

	/**
	 * 建造查询用SolrServer
	 */
	private void buildQuerySolrClient() {
		this.validConf(); // 必须是已配置的对象
		Type type = this.conf.getType();
		if (this.isSingle()) { // 单服务器节点
			if (type.accept(HttpSolrClient.class)) {
				this.querySolrClient = this.buildHttpSolrClient();
				this.httpSolrClient = this.querySolrClient;
			}
		}
		if (this.querySolrClient == null) { // 负载均衡SolrServer
			if (type.accept(LBHttpSolrClient.class)) {
				this.querySolrClient = this.buildLBHttpSolrClient();
			}
		}
		this.querySolrClientBuilt = true;
	}

	private SolrClient buildConcurrentUpdateSolrClient() {
		String serverUrl = this.conf.getServerUrls().iterator().next();
		ConcurrentUpdateSolrClient solrClient = new ConcurrentUpdateSolrClient(serverUrl, 256, 8);
		solrClient.setConnectionTimeout(this.conf.getConnectionTimeout());
		solrClient.setParser(this.conf.getResponseParser());
		solrClient.setSoTimeout(this.conf.getReadTimeout());
		solrClient.setRequestWriter(this.conf.getRequestWriter());
		return solrClient;
	}

	private SolrClient buildHttpSolrClient() {
		String serverUrl = this.conf.getServerUrls().iterator().next();
		HttpSolrClient solrClient = new HttpSolrClient(serverUrl);
		solrClient.setConnectionTimeout(this.conf.getConnectionTimeout());
		solrClient.setDefaultMaxConnectionsPerHost(this.conf.getMaxConnectionsPerHost());
		solrClient.setFollowRedirects(false);
		//下面这句代码需要自己实现
//		solrClient.setMaxRetries(this.conf.isRetry() ? 1 : 0);
		solrClient.setMaxTotalConnections(this.conf.getMaxTotalConnections());
		solrClient.setParser(this.conf.getResponseParser());
		solrClient.setSoTimeout(this.conf.getReadTimeout());
		solrClient.setRequestWriter(this.conf.getRequestWriter());
		return solrClient;
	}

	private SolrClient buildLBHttpSolrClient() {
		Iterator<String> ite = this.conf.getServerUrls().iterator();
		String url = null;
		if (ite.hasNext()) {
			url = ite.next();
		}
		LBHttpSolrClient solrClient = null;

		try {
			solrClient = new LBHttpSolrClient(url);
			while (ite.hasNext()) {
				solrClient.addSolrServer(ite.next());
			}
		} catch (MalformedURLException e) {
			log.error("Illegal URL", e);
			solrClient = null;
			return solrClient;
		}
		solrClient.setAliveCheckInterval(this.conf.getAliveCheckInterval());
		solrClient.setConnectionTimeout(this.conf.getConnectionTimeout());
		solrClient.setParser(this.conf.getResponseParser());
		solrClient.setSoTimeout(this.conf.getReadTimeout());
		solrClient.setRequestWriter(this.conf.getRequestWriter());
		return solrClient;
	}

}
