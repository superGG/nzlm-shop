package com.earl.shopping.serverImpl;

import java.util.List;

import com.earl.shopping.daoImpl.GoodsDaoImpl;
import com.earl.shopping.server.GoodsService;
import com.earl.solrj.query.pojo.GoodsPo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
public class GoodsServiceImpl extends BaseServiceImpl<GoodsPo> implements
		GoodsService {

	public GoodsServiceImpl(){
		this.baseDao = new GoodsDaoImpl();
	}
	
	@Override
	public void save(GoodsPo goods){
		super.save(goods);
		
	}
	
	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}
	
	
	public List<GoodsPo> queryByWord(GoodsPo goods){
		
		return null;
	}
	
	
}
