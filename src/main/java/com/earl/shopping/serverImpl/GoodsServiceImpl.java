package com.earl.shopping.serverImpl;

import java.util.List;

import com.earl.shopping.dao.GoodsDao;
import com.earl.shopping.daoImpl.GoodsDaoImpl;
import com.earl.shopping.server.GoodsService;
import com.earl.solrj.query.pojo.GoodsPo;
import com.earl.solrj.query.pojo.GoodsVo;

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
	public GoodsServiceImpl(GoodsDao goodsDao){
		this.baseDao = goodsDao;
	}
	
	@Override
	public void save(GoodsPo goods){
		super.save(goods);
		
	}
	
	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}
	
	public void update(GoodsPo goods) {
		super.update(goods);
	}
	
	public GoodsPo get(Integer id) {
		return (GoodsPo) super.get(id);
	}
	
	
	public List<GoodsPo> queryByWord(GoodsPo goods){
		
		return null;
	}

	@Override
	public GoodsVo getCategory(GoodsPo model, GoodsVo goodsVo) {
		// TODO 得到有组织的类别，并且返回Vo
		return null;
	}
	
	
}
