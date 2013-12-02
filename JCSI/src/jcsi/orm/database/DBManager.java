package jcsi.orm.database;

public final class DBManager {

	private static DBManager INSTANCE = null;
	
	private DBManager() {

	}
	
	public static synchronized DBManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DBManager();
		}
		return INSTANCE;
	}
}
