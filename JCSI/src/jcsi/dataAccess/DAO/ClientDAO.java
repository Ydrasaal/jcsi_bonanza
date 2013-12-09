package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.orm.entity.Client;
import jcsi.orm.entity.Product;

public class ClientDAO extends ADAO<Client> {

	private static ClientDAO instance = null;
	
	public static synchronized ClientDAO getInstance() {
		if (ClientDAO.instance == null) {
			ClientDAO.instance = new ClientDAO();
		}
		return ClientDAO.instance;
	}
	
	private ClientDAO() {
		super("Client");
	}
	
	/**
	 * Retrieve clients from first name
	 * @param first_name
	 * @return Client list
	 */
	public List<Client> getAllByFirstName(String first_name) {
		return this.getAllBy("where last_name = " + first_name);
	}
	
	/**
	 * Retrieve clients from last name
	 * @param last_name
	 * @return Client list
	 */
	public List<Client> getAllByLastName(String last_name) {
		return this.getAllBy("where last_name = " + last_name);
	}

	/**
	 * Retrieve clients from email
	 * @param email
	 * @return Client list
	 */
	public List<Client> getAllByEMail(String email) {
		return this.getAllBy("where email = " + email);
	}
	
	//TODO lower-level coordinates query
	
	/**
	 * Retrieve clients from city
	 * @param city
	 * @return Client list
	 */
	public List<Client> getAllByCity(String city) {
		//TODO I suck at sql
		return null;
	}
	
	/**
	 * Retrieve clients from country
	 * @param country
	 * @return Client list
	 */
	public List<Client> getAllByCountry(String country) {
		//TODO I suck at sql
		return null;
	}
	
	/**
	 * Retrieve clients from phone
	 * @param phone
	 * @return Client list
	 */
	public List<Client> getAllByPhone(String phone) {
		//TODO I suck at sql
		return null;
	}
	
	
	/**
	 * Retrieve clients with a product in cart
	 * @param p Product object
	 * @return Client list
	 */
	public List<Client> getAllByProduct(Product p) {
		if (p != null) {
			return this.getAllByProduct(p.getId());
		}
		return null;
	}

	/**
	 * Retrieve clients with a product in cart
	 * @param productID product Id
	 * @return Client list
	 */
	public List<Client> getAllByProduct(long product_id) {
		// TODO I suck at sql
		return null;
	}
}