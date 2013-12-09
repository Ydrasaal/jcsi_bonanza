package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.orm.entity.Client;

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
}
