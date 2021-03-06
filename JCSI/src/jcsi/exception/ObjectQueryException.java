/**
 * 
 */
package jcsi.exception;

import jcsi.log.UniLogger;

/**
 * @author kapous_c
 *
 */

public class ObjectQueryException extends DAOException {

	private static final long serialVersionUID = 1L;

	public ObjectQueryException(String s) {
		super();
		UniLogger.INSTANCE.error("SQL Query failure : " + s);
	}

}
