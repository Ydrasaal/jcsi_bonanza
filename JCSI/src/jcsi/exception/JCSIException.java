package jcsi.exception;

import jcsi.log.UniLogger;

public class JCSIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JCSIException() {
		super();
		UniLogger log = UniLogger.getInstance();
		log.error("Something went wrong in JCSI. Terminating");
	}

}
