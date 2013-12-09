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
	 * Retrieve clients from last name
	 * @param last_name
	 * @return results List
	 */
	public List<Client> getAllByName(String last_name) {
		return this.getAllBy("where last_name = " + last_name);
	}
	
	public List<Client> getAllByEMail(String email) {
		return null;
	}
}
