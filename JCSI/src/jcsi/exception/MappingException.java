package jcsi.exception;

import jcsi.log.UniLogger;

public class MappingException extends DAOException {

	private static final long serialVersionUID = 1L;

	public MappingException() {
		super();
		UniLogger.INSTANCE.error("Object Relationnal Mappping does not correspond to the real database.");
	}

}
