package jcsi.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jcsi.configuration.ConfLoader;
import jcsi.exception.BadConfException;

public final class DBConnector {

	private Connection conPool;
	public Connection getConPool() {
		return conPool;
	}

	public void setConPool(Connection conPool) {
		this.conPool = conPool;
	}

	private final ConfLoader sessionConf;
	private final String urlConnection;

	public DBConnector(ConfLoader config) {
		sessionConf = config;
		urlConnection = sessionConf.getConf("remoteAdress");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() {
		System.out.println("Trying to connect to remote database...");
		
		try {
			conPool	= DriverManager.getConnection(urlConnection, sessionConf.getConf("username"), sessionConf.getConf("password"));
			System.out.println("Connection Succesful, let's work on the database...");
		} catch (SQLException e) {
			System.out.println("Connection failed, check your exceptions !");
			e.printStackTrace();
			throw new BadConfException();
		}
		return conPool;
	}
}
