package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.exception.DAOException;
import jcsi.orm.entity.Category;
import jcsi.orm.entity.Product;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Expression;

@SuppressWarnings({"unchecked", "deprecation"})
public enum ProductDAO implements IDAO<Product> {

	INSTANCE;
	
	@Override
	public Product getById(long id) {
		try {
			return (Product) CRUDManager.getSession().get(Product.class, id);
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Product> getAll() {
		try {
			return CRUDManager.getSession().createCriteria(Product.class).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}

	}
	
	public Product getByName(String name) {
		try {
			List<Product> l = CRUDManager.getSession().createCriteria(Product.class).add(Expression.eq("name", name)).list();
			if (l.size() > 0) {
				return l.get(0);
			}
			return null;
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}

	}
	
	public List<Product> getAllByCategory(Category c) {
		try {
			if (c != null) {
				return this.getAllByCategory(c.getId());
			}
			return null;
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}

	}
	
	public List<Product> getAllByCategory(long category_id) {
		try {
			return CRUDManager.getSession().createCriteria(Product.class).createCriteria("category")
					.add(Expression.eq("id", (int) category_id)).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}

	}
}
