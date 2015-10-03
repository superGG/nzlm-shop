package com.earl.shopping.serverImpl;

import java.util.List;


import org.junit.Assert;

import com.earl.shopping.dao.BaseDao;
import com.earl.shopping.server.BaseService;

/**
 * @author Administrator
 * 
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T> {

	// 不同的T对应不同的Dao

	@SuppressWarnings("rawtypes")
	
	BaseDao baseDao;

	public BaseServiceImpl() {

	}

	@SuppressWarnings("unchecked")
	public void save(T model) {

		baseDao.save(model);
	}

	@SuppressWarnings("unchecked")
	public void update(T t) {
		baseDao.update(t);
	}

	public void deleteById(Integer id) {
		baseDao.deleteById(id);
	}

	@SuppressWarnings("unchecked")
	public T get(Integer id) {
		return (T) baseDao.get(id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return baseDao.findAll();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByGivenCreteria(T object) {

		return baseDao.findByGivenCriteria(object);
	}

}
