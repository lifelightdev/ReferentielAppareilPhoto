package life.light.common.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import life.light.common.bean.Modele;

import life.light.common.persistence.HibernateUtil;

public class ModeleDAOImpl implements ModeleDAO<Modele, Integer> {

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

	public void persist(Modele entity) {
		getCurrentSession().save(entity);
	}

	public void update(Modele entity) {
		getCurrentSession().update(entity);
	}

	public Modele findById(Integer id) {
		Modele modele = (Modele) getCurrentSession().get(Modele.class, id);
		return modele;
	}

	public void delete(Modele entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Modele> findAll() {
		List<Modele> modeles = (List<Modele>) getCurrentSession().createQuery("from Modele").list();
		return modeles;
	}

	public void deleteAll() {
		List<Modele> entityList = findAll();
		for (Modele entity : entityList) {
			delete(entity);
		}
	}
}
