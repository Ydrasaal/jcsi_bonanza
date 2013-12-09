package jcsi.dataAccess.DAO;

import java.util.HashSet;

import jcsi.orm.entity.Category;
import jcsi.orm.entity.Product;

public class CategoryDAO extends ADAO<Category> {
	
	private static CategoryDAO instance = null;
	
	public static synchronized CategoryDAO getInstance() {
		if (CategoryDAO.instance == null) {
			CategoryDAO.instance = new CategoryDAO();
		}
		return CategoryDAO.instance;
	}
	
	private CategoryDAO() {
		super("Category");
	}
	
	public void loadProducts(Category c) {
		if (c != null) {
			c.products.clear();
			c.products = new HashSet<Product>(ProductDAO.getInstance().getAllByCategory(c));
		}
	}
	
	public Category getByName(String category_name) {
		return this.getBy("where category_name = '" + category_name + "'");
	}
	
	public Category getByProduct(Product p) {
		if (p != null) {
			this.getByProduct(p.getId());
		}
		return null;
	}

	public Category getByProduct(long product_id) {
		//TODO NORAJ
		return null;
	}
}
