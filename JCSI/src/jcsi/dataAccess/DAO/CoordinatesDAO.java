package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.orm.entity.Client;
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
	
	public List<Coordinates> getAllByAddress(String address) {
		return this.getAllBy("where address = '" + address + "'");
	}
	
	public List<Coordinates> getAllByCity(String city) {
		return this.getAllBy("where city = '" + city + "'");
	}
	
	public List<Coordinates> getAllByCountry(String country) {
		return this.getAllBy("where country = '" + country + "'");
	}
	
	public Coordinates getByClient(Client c) {
		if (c != null) {
			return this.getByClient(c.getId());
		}
		return null;
	}
	
	public Coordinates getByClient(long client_id) {
		//TODO YODLEIHIIII
		return null;
	}

}
