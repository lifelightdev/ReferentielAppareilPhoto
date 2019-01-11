package life.light.common.service;

import life.light.common.dao.TypeDAOImpl;

import java.util.List;

import life.light.common.bean.Type;

public class TypeService {

	private static TypeDAOImpl typeDao;

	public TypeService() {
		typeDao = new TypeDAOImpl();	
	    }

	public void persist(Type entity) {
		typeDao.openCurrentSessionwithTransaction();
		typeDao.persist(entity);
		typeDao.closeCurrentSessionwithTransaction();
	}

	public void update(Type entity) {
		typeDao.openCurrentSessionwithTransaction();
		typeDao.update(entity);
		typeDao.closeCurrentSessionwithTransaction();
	}

	public Type findById(Integer id) {
		typeDao.openCurrentSession();
		Type type = typeDao.findById(id);
		typeDao.closeCurrentSession();
		return type;
	}

	public void delete(Integer id) {
		typeDao.openCurrentSessionwithTransaction();
		Type type = typeDao.findById(id);
		typeDao.delete(type);
		typeDao.closeCurrentSessionwithTransaction();
	}

	public List<Type> findAll() {
		typeDao.openCurrentSession();
		List<Type> types = typeDao.findAll();
		typeDao.closeCurrentSession();
		return types;

	}

	public void deleteAll() {
		typeDao.openCurrentSessionwithTransaction();
		typeDao.deleteAll();
		typeDao.closeCurrentSessionwithTransaction();
	}

	public TypeDAOImpl typeDao() {
		return typeDao;
	}

}
