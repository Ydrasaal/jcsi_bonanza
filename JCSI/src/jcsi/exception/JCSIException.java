package jcsi.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JCSIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JCSIException() {
		super();
		Logger log = Logger.getLogger(this.getClass().getName());
		log.setLevel(Level.SEVERE);
		log.severe("Something went wrong in JCSI. Terminating");
	}

}
