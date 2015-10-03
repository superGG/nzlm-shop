package com.earl.shopping.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.earl.solrj.query.pojo.TypesPo;

/**
 * 
 * 用途+action 如Demo+Action-->DemoAction
 * 
 * @author Administrator
 * 
 */
public class TypesAction extends BaseAction<TypesPo> {

	Logger logger = LogManager.getLogger(this.getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	// 添加索引.
	public void addCategory() throws Exception {
		// 从前端获取到的Po 转成 Vo 再进行,同时保存po到数据库
		typesServer.save(model);
		
	}

	/**
	 * 通过id删除商品.
	 * 
	 * @throws Exception
	 */
	public void deleGoodsAction() throws Exception {
		
		typesServer.deleteById(model.getId());
	}
	
	/**
	 * 
	 * 通过查询条件更新索引.
	 * 
	 * @throws Exception
	 * 
	 */
		public void updateGoodsAction() throws Exception {
		
		typesServer.update(model);
	}
}
