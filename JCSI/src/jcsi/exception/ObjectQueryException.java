/**
 * 
 */
package jcsi.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kapous_c
 *
 */

public class ObjectQueryException extends DAOException {

	private static final long serialVersionUID = 1L;

	public ObjectQueryException(String s) {
		super();
		Logger log = Logger.getLogger(this.getClass().getName());
		log.setLevel(Level.SEVERE);
		log.severe("SQL Query failure : " + s);
	}

}
