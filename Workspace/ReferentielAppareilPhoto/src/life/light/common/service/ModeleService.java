package life.light.common.service;

import life.light.common.dao.ModeleDAOImpl;

import java.util.List;

import life.light.common.bean.Modele;

public class ModeleService {

	private static ModeleDAOImpl modeleDao;

	public ModeleService() {
		modeleDao = new ModeleDAOImpl();	
	    }

	public void persist(Modele entity) {
		modeleDao.openCurrentSessionwithTransaction();
		modeleDao.persist(entity);
		modeleDao.closeCurrentSessionwithTransaction();
	}

	public void update(Modele entity) {
		modeleDao.openCurrentSessionwithTransaction();
		modeleDao.update(entity);
		modeleDao.closeCurrentSessionwithTransaction();
	}

	public Modele findById(Integer id) {
		modeleDao.openCurrentSession();
		Modele modele = modeleDao.findById(id);
		modeleDao.closeCurrentSession();
		return modele;
	}

	public void delete(Integer id) {
		modeleDao.openCurrentSessionwithTransaction();
		Modele modele = modeleDao.findById(id);
		modeleDao.delete(modele);
		modeleDao.closeCurrentSessionwithTransaction();
	}

	public List<Modele> findAll() {
		modeleDao.openCurrentSession();
		List<Modele> modeles = modeleDao.findAll();
		modeleDao.closeCurrentSession();
		return modeles;
	}

	public void deleteAll() {
		modeleDao.openCurrentSessionwithTransaction();
		modeleDao.deleteAll();
		modeleDao.closeCurrentSessionwithTransaction();
	}

	public ModeleDAOImpl appareilDao() {
		return modeleDao;
	}

}
