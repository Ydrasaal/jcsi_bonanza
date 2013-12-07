package jcsi.dataAccess;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HSessionFactory {
	
	INSTANCE;
	
	private static SessionFactory sessionFactory;

	/**
	 * Create session from hibernate.cfg.xml
	 */
	static {
        try {
        	sessionFactory = new Configuration().configure().buildSessionFactory();
        	
        } catch (Throwable ex) {
            System.err.println("HSessionFactory creation failed : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	public static SessionFactory getSessionFactory() {
		return HSessionFactory.sessionFactory;
	}

}
