package com.earl.shopping.daoImpl.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.earl.shopping.dao.TypesDao;
import com.earl.shopping.daoImpl.TypesDaoImpl;
import com.earl.solrj.query.pojo.TypesPo;

public class TypesDaoImplTest {

	TypesDao typesDao = new TypesDaoImpl();
	
	@Test
	public void testBaseDaoImpl() {
	}

	@Test
	public void testSave() {
		TypesPo types = new TypesPo();
		TypesPo parentType = new TypesPo();
		parentType.setId(4);
//		parentType.setTypeName("苹果fuqin");
		
		types.setTypeName("苹果");
		types.setParentType(parentType);
//		types.setParentTypeId(parentType);
		typesDao.save(types);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		TypesPo typesPo = typesDao.get(1);
		System.out.println(typesPo.toString());
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByGivenCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTypes(){
		typesDao.getTypes(3);
	}
	
}
