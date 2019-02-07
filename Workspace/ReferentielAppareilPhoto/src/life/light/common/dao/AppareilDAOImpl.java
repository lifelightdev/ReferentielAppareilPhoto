package life.light.common.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import life.light.common.bean.Appareil;

import life.light.common.persistence.HibernateUtil;

public class AppareilDAOImpl implements AppareilDAO<Appareil, Integer> {

	private Session currentSession;

	private Transaction currentTransaction;	

	public Session openCurrentSession() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}	

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Appareil entity) {
		getCurrentSession().save(entity);
	}

	public void update(Appareil entity) {
		getCurrentSession().update(entity);
	}

	public Appareil findById(Integer id) {
		Appareil appareil = (Appareil) getCurrentSession().get(Appareil.class, id);
		return appareil;
	}

	public void delete(Appareil entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Appareil> findAll() {
		List<Appareil> appareils = (List<Appareil>) getCurrentSession().createQuery("from Appareil").list();
		return appareils;
	}

	public void deleteAll() {
		List<Appareil> entityList = findAll();
		for (Appareil entity : entityList) {
			delete(entity);
		}
	}
}
