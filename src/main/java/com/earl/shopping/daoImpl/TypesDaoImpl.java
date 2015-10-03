package com.earl.shopping.daoImpl;

import org.hibernate.Transaction;

import com.earl.shopping.dao.TypesDao;
import com.earl.solrj.query.pojo.TypesPo;

/**
 * 
 * 
 */
public class TypesDaoImpl extends BaseDaoImpl<TypesPo> implements TypesDao {

	public TypesPo getTypes(int typesId) {
		logger.debug("进入getTypes");
		long begintime = System.currentTimeMillis();
		Transaction tran = getCurrentSession().beginTransaction();
		try {

			String hql = "from TypesPo t LEFT JOIN FETCH t.parentType LEFT JOIN FETCH t.parentType.parentType WHERE t.id = :id";
			TypesPo uniqueResult = (TypesPo) getCurrentSession()
					.createQuery(hql).setInteger("id", typesId).uniqueResult();
			tran.commit();
			return uniqueResult;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
			return null;
		} finally {
			long endtime = System.currentTimeMillis();
			long spend = endtime - begintime;
			logger.debug("退出getTypes方法,毫秒数: " + spend + "毫秒;耗费时间：" + spend
					/ 1000 + "秒");
		}
	}
}