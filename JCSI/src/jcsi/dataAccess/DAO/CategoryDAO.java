package jcsi.dataAccess.DAO;

import java.util.HashSet;
import java.util.List;

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.exception.DAOException;
import jcsi.orm.entity.Category;
import jcsi.orm.entity.Product;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Expression;

@SuppressWarnings({"unchecked", "deprecation"})
public enum CategoryDAO implements IDAO<Category> {
	
	INSTANCE;
	
	@Override
	public Category getById(long id) {
		try {
			return (Category) CRUDManager.getSession().get(Category.class, id);
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public List<Category> getAll() {
		try {
			return CRUDManager.getSession().createCriteria(Category.class).list();
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}

	}
	
	public void loadProducts(Category c) {
		try {
			if (c != null) {
				c.products.clear();
				c.products = new HashSet<Product>(ProductDAO.INSTANCE.getAllByCategory(c));
			}
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	public Category getByName(String category_name) {
		try {
			List<Category> l = CRUDManager.getSession().createCriteria(Category.class)
					.add(Expression.eq("name", category_name)).list();
			if (l.size() > 0) {
				return l.get(0);
			}
			return null;
		} catch(HibernateException e) {
			throw new DAOException(e.getMessage());
		}
	}
}
