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
	@Override
	public void save(T model) {
		Assert.assertNotNull("baseDao is null", baseDao);

		baseDao.save(model);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void deleteById(Integer id) {
		baseDao.deleteById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Integer id) {
		return (T) baseDao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return baseDao.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByGivenCreteria(T object) {

		return baseDao.findByGivenCriteria(object);
	}

}
