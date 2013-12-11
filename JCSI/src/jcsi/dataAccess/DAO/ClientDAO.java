package jcsi.dataAccess.DAO;

import java.util.HashSet;
import java.util.List;

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.exception.DAOException;
import jcsi.orm.entity.Cart;
import jcsi.orm.entity.Client;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Expression;

@SuppressWarnings({"unchecked", "deprecation"})
public enum ClientDAO implements IDAO<Client> {

	INSTANCE;
	
	@Override
	public Client getById(long id) {
		try {
			return (Client) CRUDManager.getSession().get(Client.class, id);
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Client> getAll() {
		try {
			return CRUDManager.getSession().createCriteria(Client.class).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public void loadCarts(Client c) {
		try {
			if (c != null) {
				c.carts.clear();
				c.carts = new HashSet<Cart>(CartDAO.INSTANCE.getAllByClient(c));
			}
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Retrieve clients from first name
	 * @param first_name
	 * @return Client list
	 */
	public List<Client> getAllByFirstName(String first_name) {
		try {
			return CRUDManager.getSession().createCriteria(Client.class).add(Expression.eq("first_name", first_name)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Retrieve clients from last name
	 * @param last_name
	 * @return Client list
	 */
	public List<Client> getAllByLastName(String last_name) {
		try {
			return CRUDManager.getSession().createCriteria(Client.class).add(Expression.eq("last_name", last_name)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * Retrieve clients from email
	 * @param email
	 * @return Client list
	 */
	public List<Client> getAllByEMail(String email) {
		try {
			return CRUDManager.getSession().createCriteria(Client.class).add(Expression.eq("email_address", email)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Retrieve clients from city
	 * @param city
	 * @return Client list
	 */
	public List<Client> getAllByCity(String city) {
		try {
			return CRUDManager.getSession().createCriteria(Client.class).createCriteria("coordinates")
					.add(Expression.eq("city", city)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Retrieve clients from country
	 * @param country
	 * @return Client list
	 */
	public List<Client> getAllByCountry(String country) {
		try {
			return CRUDManager.getSession().createCriteria(Client.class).createCriteria("coordinates")
					.add(Expression.eq("country", country)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * Retrieve clients from phone
	 * @param phone
	 * @return Client list
	 */
	public List<Client> getAllByPhone(String phone) {
		try {
			return CRUDManager.getSession().createCriteria(Client.class).add(Expression.eq("phone_number", phone)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
}
