package jcsi.dataAccess.DAO;

import java.util.List;

import jcsi.dataAccess.CRUD.CRUDManager;

@SuppressWarnings("unchecked")
public abstract class ADAO<T> {

	protected String name;
	
	protected ADAO(String name) {
		this.name = name;
	}
	
	protected List<T> getAllBy(String s) {
		List<T> list = CRUDManager.query("from " + this.name + " " + s);
		return list;
	}
	
	public T getById(long id) {
		List<T> list = CRUDManager.query("from " + this.name + " where id = " + id);
		return (list.size() > 0 ? list.get(0) : null);
	}
	
	public List<T> getAll() {
		return this.getAllBy("");
	}
	
}
