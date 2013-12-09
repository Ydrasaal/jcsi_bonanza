package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.orm.entity.Cart;
import jcsi.orm.entity.Client;
import jcsi.orm.entity.Product;

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
	
	/**
	 * Retrieve carts by owner
	 * @param c Owner
	 * @return Cart list
	 */
	public List<Cart> getAllByClient(Client c) {
		if (c != null) {
			return this.getAllByClient(c.getId());
		}
		return null;
	}
	
	/**
	 * Retrieve carts by owner
	 * @param client_id Client id
	 * @return Cart list
	 */
	public List<Cart> getAllByClient(long client_id) {
		//TODO
		return null;
	}
	
	/**
	 * Retrieve carts with a product inside
	 * @param p Product object
	 * @return Cart list
	 */
	public List<Cart> getAllByProduct(Product p) {
		if (p != null) {
			return this.getAllByProduct(p.getId());
		}
		return null;
	}

	/**
	 * Retrieve carts with a product inside
	 * @param productID product Id
	 * @return Cart list
	 */
	public List<Cart> getAllByProduct(long product_id) {
		// TODO I suck at sql
		return null;
	}
}
