package jcsi.dataAccess.CRUD;

import jcsi.dataAccess.HSessionFactory;

import org.hibernate.Transaction;
import org.hibernate.Session;

public class CRUDManager {
	
	private static CRUDManager instance = null;
	
	private CRUDManager() {
		// Do nothing
	}
	
	public static synchronized CRUDManager getInstance() {
		if (instance == null) {
			instance = new CRUDManager();
		}
		return instance;
	}
	
	private Transaction tx;
	private Session s;
	
	public void testOpen() {
		this.s = HSessionFactory.getSessionFactory().openSession();
		this.tx = s.beginTransaction();
	}
	
	public void testClose() {
		this.tx.commit();
		this.s.close();
	}

}
