package jcsi.dataAccess.DAO;

import java.util.List;

public interface IDAO<T> {

	public T getById(long id);
	public List<T> getAll();
}
