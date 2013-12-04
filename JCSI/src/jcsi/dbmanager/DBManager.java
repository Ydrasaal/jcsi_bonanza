package jcsi.dbmanager;

public final class DBManager {

	private static DBManager instance = null;
	
	private DBManager() {
		
	}
	
	public static synchronized DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
}
