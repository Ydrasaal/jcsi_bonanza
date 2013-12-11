<<<<<<< HEAD
package jcsi.exception;

import jcsi.log.UniLogger;

public class BadConfException extends JCSIException {

	private static final long serialVersionUID = 1L;

	public BadConfException() {
		super();
		UniLogger log = UniLogger.getInstance();
		log.error("Configuration failure ! Check the configuration file format.");
	}

=======
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

>>>>>>> 3dd9800286243c63138a4063962f4b64fe181fbe
}
