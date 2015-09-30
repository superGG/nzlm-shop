package com.earl.shopping.server;

import com.earl.solrj.query.pojo.GoodsPo;
import com.earl.solrj.query.pojo.GoodsVo;

public interface GoodsService extends BaseService<GoodsPo>{

	//通过Po中的category属性，得到Vo中的type1,type2,type3,并且返回VO
	GoodsVo getCategory(GoodsPo model, GoodsVo goodsVo);

	

	
	
	
}
