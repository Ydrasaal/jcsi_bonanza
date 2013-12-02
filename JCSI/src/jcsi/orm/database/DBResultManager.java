package jcsi.orm.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBResultManager {

	private ResultSet myResultSet;
	private ResultSetMetaData myResultMetaData;
	
	public DBResultManager(ResultSet resulted) {
		myResultSet = resulted;
		try {
			myResultMetaData = resulted.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dumpResult() {		
		int nbrColumn = 0;
		try {
			nbrColumn = myResultMetaData.getColumnCount();
			while (myResultSet.next())
			{
				for (int i = 0; i < nbrColumn; i++) {
					System.out.println("DbManager: dbConnect: resultSet 1st column=" + myResultSet.getString(i + 1)); 
				}
				System.out.print("\t\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void dumpMetaResult() {
		int nbrColumn = 0;
		String[] arrayHeader;
		
		try {
			nbrColumn = myResultMetaData.getColumnCount();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		arrayHeader	= new String[nbrColumn];
		
		for (int i = 0; i != nbrColumn; i++) 
		{
			try {
				arrayHeader[i]	= myResultMetaData.getColumnName(i + 1);
				System.out.println("DbManager: dbConnect: MetaInfo: columnName=" + myResultMetaData.getColumnName(i + 1) + 
						", columnType=" + myResultMetaData.getColumnTypeName(i + 1));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
