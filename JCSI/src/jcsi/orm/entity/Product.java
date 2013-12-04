package jcsi.orm.entity;

public class Product implements IEntity {
	
	private long	id;
	private String	name;
	private Category	category;

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
	
	/**
	 * This ensure safe use of Products as map keys
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product)
		{
			return (this.name == ((Product) obj).name);
		}
		return false; 
	}

}
