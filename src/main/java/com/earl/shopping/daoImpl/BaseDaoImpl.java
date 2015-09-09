package com.earl.shopping.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.earl.shopping.dao.BaseDao;
import com.earl.util.HibernateHelper;


/**
 * 这里用到工具类 HibernateHelper
 * 
 * @author 黄祥谦
 * @time 2015/7/16
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

	@SuppressWarnings("rawtypes")
	Class clazz; // 用来存储BaseDaoImpl泛型T的实际类型

	static Logger logger = null; // 这个日志工具暂时没有必要,驻澳用于记录日志，在构造方法中进行实例化

	SessionFactory sessionFactory;
	
	@SuppressWarnings("rawtypes")
	public BaseDaoImpl() {
//		logger = Logger.getLogger(this.getClass());
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type genType = parameterizedType.getActualTypeArguments()[0];
		System.out.println(genType + "-----baseDaoImpl");
		this.clazz = (Class) genType;
		logger.debug("construct " + clazz.getName() + " instance");
	}

	public Session getCurrentSession() {
		logger.debug("进入getCurrentSession函数");
		return HibernateHelper.getSessionFactory().getCurrentSession();
	}

	// 插入对象
	@Override
	/**
	 * @author Administrator
	 * 
	 * @Param  T   object
	 * @Result void
	 */
	public void save(T t) {
		System.out.println("dodo1");
		logger.debug("saving " + clazz.getName() + " instance");
		Transaction tran = getCurrentSession().beginTransaction();
		getCurrentSession().save(t);
		tran.commit();
	}

	// 更新对象
	@Override
	public boolean update(T t) {
		logger.debug("update " + clazz.getName() + " instance");
		try {
			Transaction tran = getCurrentSession().beginTransaction();
			getCurrentSession().update(t);
			tran.commit();
			return true;
		} catch (Exception e) {
			logger.debug(e);
			return false;
		}
	}

	// 根据ID删除对象
	@Override
	public void deleteById(int id) {
		logger.debug("delete " + clazz.getName() + " instance");
		delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int id) {
		logger.debug("get " + clazz.getName() + " instance");
		Transaction tran = getCurrentSession().beginTransaction();
		T object = (T) getCurrentSession().get(clazz, id);
		tran.commit();
		return object;
	}

	// 查找该表中的所有记录，
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Transaction tran = getCurrentSession().beginTransaction();
		String hql = "from " + clazz.getSimpleName();
		List<T> list = getCurrentSession().createQuery(hql).list();
		tran.commit();
		return list;
	}

	// 删除所有对象
	@Override
	public void deleteAll() {
		logger.debug("delete " + clazz.getName() + " instance");
		Transaction tran = getCurrentSession().beginTransaction();
		String hql = "delete from " + clazz.getName();
		getCurrentSession().createQuery(hql).executeUpdate();
		tran.commit();
	}

	// 通过对象来进行删除
	@Override
	public void delete(T persistentInstance) {
		logger.debug("delete " + clazz.getName() + " instance");
		Transaction tran = getCurrentSession().beginTransaction();
		getCurrentSession().delete(persistentInstance);
		tran.commit();
	}

	// 通过给定条件进行查询
	@Override
	public List<T> findByGivenCriteria(T object) {
		// 业务逻辑开始
		HibernateHelper.getSessionFactory().getCurrentSession()
				.beginTransaction();

		Map<String, Object> notNullParam = null;
		// Method readMethod = beanMap.getWriteMethod("id");
		notNullParam = getNotNullProperties(object);
		Criteria criteria = HibernateHelper.getSessionFactory()
				.getCurrentSession().createCriteria(clazz);
		for (String key : notNullParam.keySet()) {
			criteria.add(Restrictions.eq(key, notNullParam.get(key)));
		}

		@SuppressWarnings("unchecked")
		List<T> listObject = criteria.list();

		// 业务逻辑结束
		HibernateHelper.getSessionFactory().getCurrentSession()
				.getTransaction().commit();
		logger.debug("退出findByGivenCreteria方法");
		return listObject;
	}

	//得到object中的非空属性
	private Map<String, Object> getNotNullProperties(T object) {

		Map<String, Object> notNullParam = null;
		BeanMap beanMap = new BeanMap(object);
		// Method readMethod = beanMap.getWriteMethod("id");
		notNullParam = new HashMap<String, Object>();
		Iterator<Object> keyIterator = beanMap.keySet().iterator();
		String propertyName = null;
		while (keyIterator.hasNext()) {
			propertyName = (String) keyIterator.next();
			
			//beanMap.get(propertyName)!= ""可以加上去 
			if (!propertyName.equals("class")
					&& beanMap.get(propertyName) != null) {
				notNullParam.put(propertyName, beanMap.get(propertyName));
			}
		}
		return notNullParam;
	}

}