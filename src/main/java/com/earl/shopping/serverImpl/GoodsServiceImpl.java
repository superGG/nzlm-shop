package com.earl.shopping.serverImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.earl.shopping.dao.GoodsDao;
import com.earl.shopping.dao.TypesDao;
import com.earl.shopping.daoImpl.GoodsDaoImpl;
import com.earl.shopping.daoImpl.TypesDaoImpl;
import com.earl.shopping.server.GoodsService;
import com.earl.solrj.query.pojo.GoodsPo;
import com.earl.solrj.query.pojo.GoodsVo;
import com.earl.solrj.query.pojo.TypesPo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
public class GoodsServiceImpl extends BaseServiceImpl<GoodsPo> implements
		GoodsService {

	GoodsDao goodsDao = new GoodsDaoImpl();
	TypesDao typesDao = new TypesDaoImpl();
	public static GoodsService goodsService;
	private GoodsServiceImpl(){
		this.baseDao = goodsDao;
	}

	@Override
	public void save(GoodsPo goods){
		super.save(goods);
		
		
	}
	
	@Override
	public GoodsVo PoToVo(GoodsPo goods) throws IllegalAccessException, InvocationTargetException{
		GoodsVo goodsVo = new GoodsVo();
		//属性之间的分割符；
		String[] split = goods.getGoodsattributes().split(";");
		ArrayList<String> attributeList = new ArrayList<String>();
		for (String string : split) {
			attributeList.add(string);
		}
		goods.setGoodsattributes(null);
			BeanUtils.copyProperties(goodsVo, goods);
		goodsVo.setGoodsattributes(attributeList);
		getTypes(goods,goodsVo);
		return goodsVo;
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
	public GoodsVo getTypes(GoodsPo model, GoodsVo goodsVo) {
		TypesPo types3 = typesDao.getTypes(model.getTypeId());
		goodsVo.setGoodstype3(types3.getTypeName());
		TypesPo types2 = types3.getParentType();
		goodsVo.setGoodstype2(types2.getTypeName());
		TypesPo types1 = types2.getParentType();
		goodsVo.setGoodstype1(types1.getTypeName());
		return goodsVo;
	}
	
	public static GoodsService getInstance() {
		if(goodsService == null){
			goodsService = new GoodsServiceImpl();
		}
		return goodsService;
	}
	
	
}
