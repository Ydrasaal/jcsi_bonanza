package jcsi.orm.entity;

public class Client implements IModel {
	
	private long	id;
	private String	last_name;
	private String	first_name;
	private String	email;
	private long	coordinates_id;
	private String	phone;
	private long	cart;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadFull() {
		// TODO Auto-generated method stub

	}

}
