/**
 * 
 */
package jcsi.orm.entity;

import java.util.Map;

/**
 * @author kapous_c
 *
 */
public class Cart implements IEntity {
	
	private long					id;
	private Map<Product, Integer>	products;

	/**
	 * 
	 */
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see jcsi.orm.entity.IModel#load()
	 */
	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see jcsi.orm.entity.IModel#loadFull()
	 */
	@Override
	public void loadFull() {
		// TODO Auto-generated method stub

	}

}
