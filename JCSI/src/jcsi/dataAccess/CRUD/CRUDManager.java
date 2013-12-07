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
	
	@SuppressWarnings("rawtypes")
	public static List query(String s) {
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
	
	private static void startTransactionProtocol() {
		if (CRUDManager.session == null) {
			CRUDManager.session = HSessionFactory.getSessionFactory().openSession();
			CRUDManager.session.beginTransaction();
		}
	}
	
	private static void endTransactionProtocol() {
		if (CRUDManager.session != null) {
			CRUDManager.session.getTransaction().commit();
			CRUDManager.session.close();
			CRUDManager.session = null;
		}
	}
	
	/*
	public void testOpen() {
		this.session = HSessionFactory.getSessionFactory().openSession();
		this.transaction = session.beginTransaction();
	}
	
	public void testClose() {
		this.transaction.commit();
		this.session.close();
	}
	*/

}
