package jcsi.exception;

import jcsi.log.UniLogger;

public class BadConfException extends JCSIException {

	private static final long serialVersionUID = 1L;

	public BadConfException() {
		super();
		UniLogger log = UniLogger.getInstance();
		log.error("Configuration failure ! Check the configuration file format.");
	}
}
