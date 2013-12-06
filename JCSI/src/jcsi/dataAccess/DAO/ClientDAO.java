package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.orm.entity.Cart;
import jcsi.orm.entity.Client;
import jcsi.orm.entity.Product;

public class ClientDAO implements IDAO<Client> {

	private static ClientDAO instance = null;

	private ClientDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized ClientDAO getInstance() {
		if (instance == null) {
			instance = new ClientDAO();
		}
		return instance;
	}
	
	@Override
	public Client get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return null;
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
