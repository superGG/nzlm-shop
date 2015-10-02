package com.earl.shopping.serverImpl;

import com.earl.shopping.daoImpl.GoodsDaoImpl;
import com.earl.shopping.server.CategoryService;
import com.earl.solrj.query.pojo.CategoryPo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
public class CategoryServiceImpl extends BaseServiceImpl<CategoryPo> implements
		CategoryService{

	public CategoryServiceImpl(){
		this.baseDao = new GoodsDaoImpl();
	}
	
	@Override
	public void save(CategoryPo category){
		super.save(category);
		
	}
	
	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}
	
	
}
