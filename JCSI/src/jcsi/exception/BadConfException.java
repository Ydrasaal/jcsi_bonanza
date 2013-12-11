package jcsi.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BadConfException extends JCSIException {

	private static final long serialVersionUID = 1L;

	public BadConfException() {
		super();
		Logger log = Logger.getLogger(this.getClass().getName());
		log.setLevel(Level.SEVERE);
		log.severe("Configuration failure ! Check the configuration file format.");
	}

}
