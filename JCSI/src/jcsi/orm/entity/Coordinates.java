package jcsi.orm.entity;

public class Coordinates implements IModel {
	
	private long	id;
	private int		number;
	private String	type;
	private String	street;
	private String	city;
	private String	country;

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadFull() {
		// TODO Auto-generated method stub

	}

}
