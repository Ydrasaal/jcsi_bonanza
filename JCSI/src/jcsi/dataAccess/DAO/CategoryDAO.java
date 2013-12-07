package jcsi.dataAccess.DAO;

import jcsi.orm.entity.Category;

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
	
	@Override
	public void update(Category o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Category o) {
		// TODO Auto-generated method stub
		
	}

}
