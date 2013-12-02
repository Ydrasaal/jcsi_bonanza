package jcsi.orm.entity;

public interface IModel {
	
	public void load();
	public void loadFull();
	@Override
	public String toString();
}
