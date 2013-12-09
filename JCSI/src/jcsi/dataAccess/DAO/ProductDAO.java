package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.orm.entity.Category;
import jcsi.orm.entity.Product;

public class ProductDAO extends ADAO<Product> {

	private static ProductDAO instance = null;
	
	public static synchronized ProductDAO getInstance() {
		if (ProductDAO.instance == null) {
			ProductDAO.instance = new ProductDAO();
		}
		return ProductDAO.instance;
	}

	private ProductDAO() {
		super("Product");
	}
	
	public Product getByName(String name) {
		return this.getBy("where product_name = '" + name + "'");
	}
	
	public List<Product> getAllByCategory(Category c) {
		if (c != null) {
			return this.getAllByCategory(c.getId());
		}
		return null;
	}
	
	public List<Product> getAllByCategory(long category_id) {
		//TODO JOIN AND STUFF
		return null;
	}

	
	public List<Product> getAllByPriceRange(double low, double up) {
		//TODO TSOINTSOIN
		return null;
	}
}
