package jcsi.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MappingException extends DAOException {

	private static final long serialVersionUID = 1L;

	public MappingException() {
		super();
		Logger log = Logger.getLogger(this.getClass().getName());
		log.setLevel(Level.SEVERE);
		log.severe("Object Relationnal Mappping does not correspond to the real database.");
	}

}
