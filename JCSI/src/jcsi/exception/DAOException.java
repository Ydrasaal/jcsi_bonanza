package jcsi.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOException extends JCSIException {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		Logger log = Logger.getLogger(this.getClass().getName());
		log.setLevel(Level.SEVERE);
		log.severe("DAO transaction failed.");
	}

}
