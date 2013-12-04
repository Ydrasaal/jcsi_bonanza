package jcsi.orm.entity;

public interface IEntity {
	
	public void load();
	public void loadFull();
	@Override
	public String toString();
}
