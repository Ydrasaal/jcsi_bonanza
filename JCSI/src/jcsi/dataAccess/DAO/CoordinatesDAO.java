package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.exception.DAOException;
import jcsi.orm.entity.Coordinates;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Expression;

@SuppressWarnings({"unchecked", "deprecation"})
public enum CoordinatesDAO implements IDAO<Coordinates> {
	
	INSTANCE;
	
	@Override
	public Coordinates getById(long id) {
		try {
			return (Coordinates) CRUDManager.getSession().get(Coordinates.class, id);
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public List<Coordinates> getAll() {
		try {
			return CRUDManager.getSession().createCriteria(Coordinates.class).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}

	}
	
	

	public List<Coordinates> getAllByAddress(String address) {
		try {
			return CRUDManager.getSession().createCriteria(Coordinates.class).add(Expression.eq("address", address)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public List<Coordinates> getAllByCity(String city) {
		try {
			return CRUDManager.getSession().createCriteria(Coordinates.class).add(Expression.eq("city", city)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public List<Coordinates> getAllByCountry(String country) {
		try {
			return CRUDManager.getSession().createCriteria(Coordinates.class).add(Expression.eq("country", country)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
}
