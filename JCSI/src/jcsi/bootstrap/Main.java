/**
 * 
 */
package jcsi.bootstrap;

import java.sql.SQLException;

import jcsi.configuration.ConfLoader;
import jcsi.dbmanager.DBConnector;
import jcsi.dbmanager.DBMetaManager;
import jcsi.exception.MappingException;

/**
 * @author kapous_c
 *
 */

public class Main {

	public Main() {
	}

	/**
	 * @param args
	 * @throws MappingException 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfLoader conf  = null;
		conf = ConfLoader.getInstance();
		conf.load();
		System.out.println(conf.getConf("adress"));
		System.out.println(conf.toString());
		DBConnector tConnect = new DBConnector(conf);
		tConnect.connect();
		DBMetaManager dbmeta = new DBMetaManager(tConnect.getConPool());
		try {
			System.out.println(dbmeta.getMyDbMetaData().getUserName());
			System.out.println(dbmeta.getMyDbMetaData().getURL());
			System.out.println(dbmeta.getMyDbMetaData().getDriverName());
			System.out.println(dbmeta.getMyDbMetaData().getCatalogTerm());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MappingException();
		}
	}

}
