package life.light.common.service;

import life.light.common.dao.MarqueDAOImpl;

import java.util.List;

import life.light.common.bean.Marque;

public class MarqueService {

	private static MarqueDAOImpl marqueDao;

	public MarqueService() {
		marqueDao = new MarqueDAOImpl();	
	    }

	public void persist(Marque entity) {
		marqueDao.openCurrentSessionwithTransaction();
		marqueDao.persist(entity);
		marqueDao.closeCurrentSessionwithTransaction();
	}

	public void update(Marque entity) {
		marqueDao.openCurrentSessionwithTransaction();
		marqueDao.update(entity);
		marqueDao.closeCurrentSessionwithTransaction();
	}

	public Marque findById(Integer id) {
		marqueDao.openCurrentSession();
		Marque marque = marqueDao.findById(id);
		marqueDao.closeCurrentSession();
		return marque;
	}

	public void delete(Integer id) {
		marqueDao.openCurrentSessionwithTransaction();
		Marque marque = marqueDao.findById(id);
		marqueDao.delete(marque);
		marqueDao.closeCurrentSessionwithTransaction();
	}

	public List<Marque> findAll() {
		marqueDao.openCurrentSession();
		List<Marque> marques = marqueDao.findAll();
		marqueDao.closeCurrentSession();
		return marques;

	}

	public void deleteAll() {
		marqueDao.openCurrentSessionwithTransaction();
		marqueDao.deleteAll();
		marqueDao.closeCurrentSessionwithTransaction();
	}

	public MarqueDAOImpl marqueDao() {
		return marqueDao;
	}

}
