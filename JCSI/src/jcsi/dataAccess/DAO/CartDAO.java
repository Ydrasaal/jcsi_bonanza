package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.orm.entity.Cart;
import jcsi.orm.entity.Client;
import jcsi.orm.entity.Product;

public class CartDAO implements IDAO<Cart> {

	private static CartDAO instance = null;
	
	private CartDAO() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized CartDAO getInstance() {
		if (instance == null) {
			instance = new CartDAO();
		}
		return instance;
	}

	@Override
	public Cart get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cart o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cart o) {
		// TODO Auto-generated method stub
	}	
}
