package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.exception.DAOException;
import jcsi.orm.entity.Cart;
import jcsi.orm.entity.Client;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Expression;

@SuppressWarnings({"unchecked", "deprecation"})
public enum CartDAO implements IDAO<Cart> {

	INSTANCE;
	
	@Override
	public Cart getById(long id) {
		try {
			return (Cart) CRUDManager.getSession().get(Cart.class, id);
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public List<Cart> getAll() {
		try {
			return CRUDManager.getSession().createCriteria(Cart.class).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}

	}
	
	
	/**
	 * Retrieve carts by owner
	 * @param c Owner
	 * @return Cart list
	 */
	public List<Cart> getAllByClient(Client c) {
		try {
			if (c != null) {
				return this.getAllByClient(c.getId());
			}
			return null;
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Retrieve carts by owner
	 * @param client_id Client id
	 * @return Cart list
	 */
	public List<Cart> getAllByClient(long client_id) {
		try {
			return CRUDManager.getSession().createCriteria(Cart.class).createCriteria("client")
					.add(Expression.eq("id", client_id)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public List<Cart> getAllByPaymentState(boolean state) {
		try {
			return CRUDManager.getSession().createCriteria(Cart.class).add(Expression.eq("paid", state)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
}
