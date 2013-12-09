package jcsi.dataAccess.CRUD;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jcsi.dataAccess.HSessionFactory;
import jcsi.orm.entity.AEntity;

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
		System.out.println("Query : " + s);
		CRUDManager.startTransactionProtocol();
		Query query = CRUDManager.session.createQuery(s);
		List list = query.list();
		CRUDManager.endTransactionProtocol();
		return list;
	}
	
	public static void createOrUpdate(AEntity e) {
		CRUDManager.startTransactionProtocol();
		CRUDManager.session.saveOrUpdate(e);
		CRUDManager.endTransactionProtocol();
	}
	
	public static void createOrUpdateAll(Collection<AEntity> c) {
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
	}
	
	public static void createOrUpdateAll(AEntity ... entities) {
		CRUDManager.createOrUpdateAll(Arrays.asList(entities));
	}

	public static void delete(AEntity e) {
		CRUDManager.startTransactionProtocol();
		CRUDManager.session.delete(e);
		CRUDManager.endTransactionProtocol();		
	}
	
	public static void deleteAll(List<AEntity> l) {
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
	}
	
	public static void deleteAll(AEntity ... entities) {
		CRUDManager.deleteAll(Arrays.asList(entities));
	}
	
	/**
	 * Open a new session (If there isn't already one) and start a transaction
	 */
	public static void startTransactionProtocol() {
		if (CRUDManager.session == null) {
			CRUDManager.session = HSessionFactory.getSessionFactory().openSession();
			CRUDManager.session.beginTransaction();
		}
	}
	
	/**
	 * If there's an open session, commit the transaction and close the session
	 */
	public static void endTransactionProtocol() {
		if (CRUDManager.session != null) {
			CRUDManager.session.getTransaction().commit();
			CRUDManager.session.close();
			CRUDManager.session = null;
		}
	}
	
	/**
	 * Open a new session (Close the old one if there's one)
	 */
	public static void openSession() {
		if (CRUDManager.session != null) {
			CRUDManager.session.close();
		}
		CRUDManager.session = HSessionFactory.getSessionFactory().openSession();
	}
	
	/**
	 * Close session if it's open, else do nothing
	 */
	public static void closeSession() {
		//TODO Exception if session null
		if (CRUDManager.session.isOpen()) {
			CRUDManager.session.close();
			CRUDManager.session = null;
		}
	}
	
	/**
	 * Clear session
	 */
	public static void clearSession() {
		//TODO blahblabh
		CRUDManager.session.clear();
	}
	
	/**
	 * Flush session
	 */
	public static void flushSession() {
		//TODO pika pika
		CRUDManager.session.flush();
	}
	
	/**
	 * Start a transaction
	 */
	public static void beginTransaction() {
		//TODO Exception if session is null
		CRUDManager.session.beginTransaction();
	}
	
	/**
	 * Commit transaction
	 */
	public static void commitTransaction() {
		//TODO Exception if session null or transaction not open
		CRUDManager.session.getTransaction().commit();
	}
	
	/**
	 * Rollback transaction
	 */
	public static void rollbackTransaction() {
		//TODO Exception if session null or transaction not open
		CRUDManager.session.getTransaction().rollback();
	}
}
