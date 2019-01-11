package life.light.common.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import life.light.common.bean.Marque;

import life.light.common.persistence.HibernateUtil;

public class MarqueDAOImpl implements MarqueDAO<Marque, Integer> {

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

	public void persist(Marque entity) {
		getCurrentSession().save(entity);
	}

	public void update(Marque entity) {
		getCurrentSession().update(entity);
	}

	public Marque findById(Integer id) {
		Marque marque = (Marque) getCurrentSession().get(Marque.class, id);
		return marque;
	}

	public void delete(Marque entity) {
		getCurrentSession().delete(entity);
	}

	public List<Marque> findAll() {
		List<Marque> marques = (List<Marque>) getCurrentSession().createQuery("from Marque").list();
		return marques;
	}

	public void deleteAll() {
		List<Marque> entityList = findAll();
		for (Marque entity : entityList) {
			delete(entity);
		}
	}

}
