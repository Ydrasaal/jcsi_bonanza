/**
 * 
 */
package jcsi.orm.entity;

import java.util.Map;

/**
 * @author kapous_c
 *
 */
public class Cart implements IModel {
	
	private long	id;
	private Client	client_id;
	private Map<String, Integer>	products;

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
