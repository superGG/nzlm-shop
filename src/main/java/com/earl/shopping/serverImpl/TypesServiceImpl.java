package com.earl.shopping.serverImpl;

import java.util.List;

import com.earl.shopping.daoImpl.TypesDaoImpl;
import com.earl.shopping.server.TypesService;
import com.earl.solrj.query.pojo.TypesPo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
public class TypesServiceImpl extends BaseServiceImpl<TypesPo> implements
		TypesService {

	public TypesServiceImpl(){
		this.baseDao = new TypesDaoImpl();
	}
	
	@Override
	public void save(TypesPo types){
		super.save(types);
		
	}
	
	@Override
	public void deleteById(Integer id) {
		super.deleteById(id);
	}
	
	public void update(TypesPo types) {
		super.update(types);
	}
	
	public TypesPo get(Integer id) {
		return (TypesPo) super.get(id);
	}
	
	
	public List<TypesPo> queryByWord(TypesPo types){
		
		return null;
	}
	
	
}
