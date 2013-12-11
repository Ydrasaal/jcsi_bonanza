package jcsi.dataAccess.CRUD;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jcsi.dataAccess.HSessionFactory;
import jcsi.exception.DAOException;
import jcsi.exception.ObjectQueryException;
import jcsi.orm.entity.AEntity;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public enum CRUDManager {
	
	INSTANCE;
	
	private static Session	session = null;
	
	/**
	 * Send a SQL or HQL query to the server
	 * @param s query as String
	 * @return results as List
	 */
	@SuppressWarnings("rawtypes")
	public static List query(String s) {
		try {
			CRUDManager.startTransactionProtocol();
			Query query = CRUDManager.session.createQuery(s);
			List list = query.list();
			return list;
		} catch(HibernateException e) {
			throw new ObjectQueryException(e.getMessage());
		}
	}
	
	public static void createOrUpdate(AEntity entity) {
		try {
			CRUDManager.startTransactionProtocol();
			CRUDManager.session.saveOrUpdate(entity);
			CRUDManager.endTransactionProtocol();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public static void createOrUpdateAll(Collection<AEntity> c) {
		try {
			int i = 0;
			CRUDManager.startTransactionProtocol();
			for (AEntity e : c) {
				CRUDManager.session.saveOrUpdate(e);
				i++;
				if (i >= 20) {
					CRUDManager.session.flush();
					CRUDManager.session.clear();
					i = 0;
				}
			}
			CRUDManager.endTransactionProtocol();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public static void createOrUpdateAll(AEntity ... entities) {
		CRUDManager.createOrUpdateAll(Arrays.asList(entities));
	}

	public static void delete(AEntity entity) {
		try {
			CRUDManager.startTransactionProtocol();
			CRUDManager.session.delete(entity);
			CRUDManager.endTransactionProtocol();		
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public static void deleteAll(List<AEntity> l) {
		try {
			int i = 0;
			CRUDManager.startTransactionProtocol();
			for (AEntity e : l) {
				CRUDManager.session.delete(e);
				i++;
				if (i >= 20) {
					CRUDManager.session.flush();
					CRUDManager.session.clear();
					i = 0;
				}
			}
			CRUDManager.endTransactionProtocol();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public static void deleteAll(AEntity ... entities) {
		CRUDManager.deleteAll(Arrays.asList(entities));
	}
	
	/**
	 * Open a new session (If there isn't already one) and start a transaction
	 */
	public static void startTransactionProtocol() {
		try {
			if (CRUDManager.session == null) {
				CRUDManager.session = HSessionFactory.getSessionFactory().openSession();
			}
			CRUDManager.session.beginTransaction();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * If there's an open session, commit the transaction
	 */
	public static void endTransactionProtocol() {
		try {
			if (CRUDManager.session != null) {
				CRUDManager.session.getTransaction().commit();
			}
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public static Session getSession() {
		try {
			if (CRUDManager.session == null) {
				CRUDManager.openSession();
			}
			return CRUDManager.session;
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Open a new session (Close the old one if there's one)
	 */
	public static void openSession() {
		try {
			if (CRUDManager.session != null) {
				CRUDManager.session.close();
			}
			CRUDManager.session = HSessionFactory.getSessionFactory().openSession();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Close session if it's open, else do nothing
	 */
	public static void closeSession() {
		try {
			if (CRUDManager.session != null && CRUDManager.session.isOpen()) {
				CRUDManager.session.close();
				CRUDManager.session = null;
			}
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Clear session
	 */
	public static void clearSession() {
		if (CRUDManager.session == null) {
			throw new DAOException("Session not initialized");
		}
		CRUDManager.session.clear();
	}
	
	/**
	 * Flush session
	 */
	public static void flushSession() {
		if (CRUDManager.session == null) {
			throw new DAOException("Session not initialized");
		}
		CRUDManager.session.flush();
	}
	
	/**
	 * Start a transaction
	 */
	public static void beginTransaction() {
		try {
			CRUDManager.session.beginTransaction();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Commit transaction
	 */
	public static void commitTransaction() {
		try {
			CRUDManager.session.getTransaction().commit();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Rollback transaction
	 */
	public static void rollbackTransaction() {
		try {
			CRUDManager.session.getTransaction().rollback();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
}
