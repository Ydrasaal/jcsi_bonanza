package jcsi.dataAccess.CRUD;

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
		CRUDManager.setupNewSession();
		Query query = CRUDManager.session.createQuery(s);
		List list = query.list();
		CRUDManager.endSession();
		return list;
	}
	
	public static void createOrUpdate(AEntity e) {
		CRUDManager.setupNewSession();
		CRUDManager.session.saveOrUpdate(e);
		CRUDManager.endSession();
	}
	
	private static void setupNewSession() {
		if (CRUDManager.session == null) {
			CRUDManager.session = HSessionFactory.getSessionFactory().openSession();
			CRUDManager.session.beginTransaction();
		}
	}
	
	private static void endSession() {
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
