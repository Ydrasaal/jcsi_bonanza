/**
 * 
 */
package jcsi.orm.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author kapous_c
 *
 */

@Entity
public class Cart implements IEntity {
	
	private long					id;
	private Map<Product, Integer>	products;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
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
