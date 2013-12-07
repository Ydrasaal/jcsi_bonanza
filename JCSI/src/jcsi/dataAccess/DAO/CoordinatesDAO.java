package jcsi.dataAccess.DAO;

import jcsi.orm.entity.Coordinates;

public class CoordinatesDAO extends ADAO<Coordinates> {
	
	private static CoordinatesDAO instance = null;
	
	public static synchronized CoordinatesDAO getInstance() {
		if (CoordinatesDAO.instance == null) {
			CoordinatesDAO.instance = new CoordinatesDAO();
		}
		return CoordinatesDAO.instance;
	}
	
	private CoordinatesDAO() {
		super("Coordinates");
	}

	@Override
	public void update(Coordinates o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Coordinates o) {
		// TODO Auto-generated method stub
		
	}
}
