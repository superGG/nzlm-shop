package com.earl.shopping.dao;

import java.util.List;

import org.hibernate.Session;


/**
 * Data access interface for domain model
 * 
 * @author MyEclipse Persistence Tools
 */
public interface BaseDao<T> {

	Session getCurrentSession();

	void save(T t);

	boolean update(T t);

	void deleteById(int id);

	/**
	 * findById 功能跟get(int )一样
	 * 
	 * @param id
	 * @return
	 */
	T get(int id);

	List<T> findAll();

	void deleteAll();

	void delete(T persistentInstance);

//	List<T> pageFindAll(PageInfo pageInfo);
	
	public List<T> findByGivenCriteria(T object);
	
//	public List<T> findByGivenCreteriaWithPage(T object,PageInfo pageInfo);
	
}