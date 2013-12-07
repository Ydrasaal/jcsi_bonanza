package jcsi.dataAccess.DAO;

import jcsi.orm.entity.Cart;

public class CartDAO extends ADAO<Cart> {

	private static CartDAO instance = null;
	
	public static synchronized CartDAO getInstance() {
		if (CartDAO.instance == null) {
			CartDAO.instance = new CartDAO();
		}
		return CartDAO.instance;
	}
	
	private CartDAO() {
		super("Cart");
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
