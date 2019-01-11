package life.light.common.service;

import life.light.common.dao.AppareilDAOImpl;

import java.util.List;

import life.light.common.bean.Appareil;

public class AppareilService {

	private static AppareilDAOImpl appareilDao;

	public AppareilService() {
		appareilDao = new AppareilDAOImpl();	
	    }

	public void persist(Appareil entity) {
		appareilDao.openCurrentSessionwithTransaction();
		appareilDao.persist(entity);
		appareilDao.closeCurrentSessionwithTransaction();
	}

	public void update(Appareil entity) {
		appareilDao.openCurrentSessionwithTransaction();
		appareilDao.update(entity);
		appareilDao.closeCurrentSessionwithTransaction();
	}

	public Appareil findById(Integer id) {
		appareilDao.openCurrentSession();
		Appareil appareil = appareilDao.findById(id);
		appareilDao.closeCurrentSession();
		return appareil;
	}

	public void delete(Integer id) {
		appareilDao.openCurrentSessionwithTransaction();
		Appareil appareil = appareilDao.findById(id);
		appareilDao.delete(appareil);
		appareilDao.closeCurrentSessionwithTransaction();
	}

	public List<Appareil> findAll() {
		appareilDao.openCurrentSession();
		List<Appareil> appareils = appareilDao.findAll();
		appareilDao.closeCurrentSession();
		return appareils;

	}

	public void deleteAll() {
		appareilDao.openCurrentSessionwithTransaction();
		appareilDao.deleteAll();
		appareilDao.closeCurrentSessionwithTransaction();
	}

	public AppareilDAOImpl appareilDao() {
		return appareilDao;
	}

}
