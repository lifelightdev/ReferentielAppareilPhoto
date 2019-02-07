package life.light.common.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import life.light.common.bean.Type;

import life.light.common.persistence.HibernateUtil;

public class TypeDAOImpl implements TypeDAO<Type, Integer> {

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

	public void persist(Type entity) {
		getCurrentSession().save(entity);
	}

	public void update(Type entity) {
		getCurrentSession().update(entity);
	}

	public Type findById(Integer id) {
		Type type = (Type) getCurrentSession().get(Type.class, id);
		return type;
	}

	public void delete(Type entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Type> findAll() {
		List<Type> types = (List<Type>) getCurrentSession().createQuery("from Type").list();
		return types;
	}

	public void deleteAll() {
		List<Type> entityList = findAll();
		for (Type entity : entityList) {
			delete(entity);
		}
	}



}
