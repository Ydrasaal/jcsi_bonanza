package jcsi.exception;

import jcsi.log.UniLogger;

public class DAOException extends JCSIException {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		this("");
	}
	
	public DAOException(String s) {
		super();
		UniLogger log = UniLogger.getInstance();
		log.error("DAO transaction failed : " + s);
	}

}
