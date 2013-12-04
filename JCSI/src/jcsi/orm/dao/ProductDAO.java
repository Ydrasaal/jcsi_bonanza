package jcsi.orm.dao;

import java.util.List;

import jcsi.orm.entity.Category;
import jcsi.orm.entity.Product;

public class ProductDAO implements IDAO<Product> {

	private static ProductDAO instance = null;

	private ProductDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}
	
	@Override
	public Product get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product o) {
		// TODO Auto-generated method stub
		
	}

}
