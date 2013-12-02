package jcsi.dbmanager;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DBMetaManager {

	private DatabaseMetaData		myDbMetaData;
	
	public DBMetaManager(Connection ct) {
		try {
			myDbMetaData = ct.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DatabaseMetaData getMyDbMetaData() {
		return myDbMetaData;
	}
}
