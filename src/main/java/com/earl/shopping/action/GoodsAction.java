package com.earl.shopping.action;

import java.io.InputStream;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.earl.solrj.SolrService;
import com.earl.solrj.query.pojo.GoodsPo;
import com.earl.solrj.query.pojo.GoodsVo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
public class GoodsAction extends BaseAction<GoodsPo> {

	Logger logger = LogManager.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected InputStream jsonInputStream;

	private SolrService solrServer = new SolrService();

	/**
	 * 搜索的关键字,直接映射到goodslable,goodsname.
	 */
	private String keyWord;

	public InputStream getJsonInputStream() {
		return jsonInputStream;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	// 添加索引.
	public void addGoodsAction() throws Exception {
		// 从前端获取到的Po 转成 Vo 再进行,同时保存po到数据库
		goodsServer.save(model);
		GoodsVo goodsVo = new GoodsVo();
		BeanUtils.copyProperties(goodsVo, model);
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
