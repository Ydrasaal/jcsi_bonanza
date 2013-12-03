package jcsi.orm.entity;

public class Product implements IModel {
	
	private long	id;
	private String	name;
	private Category	category;
	private double	price;

	public Product() {
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
