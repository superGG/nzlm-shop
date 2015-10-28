package com.earl.shopping.action;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.earl.solrj.SolrService;
import com.earl.solrj.query.pojo.GoodsPo;
import com.earl.solrj.query.pojo.GoodsVo;

/**
 * 商品记录的action层.
 * @author Administrator
 * 
 */
public class GoodsAction extends BaseAction<GoodsPo> {

	Logger logger = LogManager.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private SolrService solrServer = new SolrService();

	/**
	 * 添加一条商品记录的同时添加一条索引.
	 * @throws Exception
	 */
	public void addGoods() throws Exception {
		goodsServer.save(model);
		GoodsVo goodsVo = goodsServer.PoToVo(model);
		solrServer.addBeanIndex(goodsVo);
	}

	/**
	 * 通过id删除商品.
	 * 
	 * @throws Exception
	 */
	public void deleGoodsAction() throws Exception {
		
		goodsServer.deleteById(model.getId());
		GoodsVo goodsVo = new GoodsVo();
		BeanUtils.copyProperties(goodsVo, model);
		solrServer.deleteById(goodsVo);
	}
	
	/**
	 * 
	 * 通过查询条件更新索引.
	 * 
	 * @throws Exception
	 * 
	 */
		public void updateGoodsAction() throws Exception {
		
		goodsServer.update(model);
		GoodsVo goodsVo = new GoodsVo();
		BeanUtils.copyProperties(goodsVo, model);
		solrServer.addBeanIndex(goodsVo);
	}
		
}
