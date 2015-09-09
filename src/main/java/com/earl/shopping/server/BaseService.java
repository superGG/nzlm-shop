package com.earl.shopping.server;

import java.util.List;

public interface BaseService<T> {

	void save(T model);

	void update(T t);

	void deleteById(Integer id);

	List<T> findAll();

//	List<T> pagefindAll(PageInfo pageInfo);

	T get(Integer id);
	
	List<T> findByGivenCreteria(T object);
	
//	List<T> findByGivenCreteriaWithPage(T object,PageInfo pageInfo);
}
