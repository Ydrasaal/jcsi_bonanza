package jcsi.dataAccess.DAO;

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

	@Override
	public void update(Product o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product o) {
		// TODO Auto-generated method stub
		
	}

}
