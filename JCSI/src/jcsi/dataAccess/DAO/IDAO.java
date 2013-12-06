package jcsi.dataAccess.DAO;

import java.util.List;

public interface IDAO<T> {
	public T get(long id);
	public List<T> getAll();
	public void update(T o);
	public void delete(T o);

}
