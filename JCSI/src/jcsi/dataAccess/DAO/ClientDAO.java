package jcsi.dataAccess.DAO;

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

	@Override
	public void update(Client o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Client o) {
		// TODO Auto-generated method stub
		
	}

}
