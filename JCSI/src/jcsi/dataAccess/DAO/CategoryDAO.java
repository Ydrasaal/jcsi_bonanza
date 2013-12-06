package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.orm.entity.Category;

public class CategoryDAO implements IDAO<Category> {
	
	private static CategoryDAO instance = null;

	public CategoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized CategoryDAO getInstance() {
		if (instance == null) {
			instance = new CategoryDAO();
		}
		return instance;
	}
	
	@Override
	public Category get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
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
