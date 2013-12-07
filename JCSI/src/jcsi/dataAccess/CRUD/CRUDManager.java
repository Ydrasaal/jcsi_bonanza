package jcsi.dataAccess.CRUD;

import jcsi.dataAccess.HSessionFactory;
import jcsi.orm.entity.AEntity;

import org.hibernate.Session;

public class CRUDManager {
	
	private static CRUDManager instance = null;
	
	private CRUDManager() {
		//Do nothing
	}
	
	public static synchronized CRUDManager getInstance() {
		if (instance == null) {
			instance = new CRUDManager();
		}
		return instance;
	}
	
	public void createOrUpdate(AEntity e) {
		Session session = HSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(e);
		session.getTransaction().commit();
		session.close();
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
