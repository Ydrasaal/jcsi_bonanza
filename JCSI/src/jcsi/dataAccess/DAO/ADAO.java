package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.dataAccess.CRUD.CRUDManager;

public abstract class ADAO<T> {

	private String name;
	
	protected ADAO(String name) {
		this.name = name;
	}
	
	@SuppressWarnings("unchecked")
	public T getById(long id) {
		List<T> list = CRUDManager.query("from " + this.name + " where id = 'id'");
		return list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		List<T> list = CRUDManager.query("from " + this.name);
		return list;
	}
	
	public void update(T o) {
		
	}
	
	public void delete(T o) {
		
	}

}
