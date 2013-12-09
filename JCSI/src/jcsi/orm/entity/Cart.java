/**
 * 
 */
package jcsi.orm.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author kapous_c
 *
 */

@Entity
@Table(name = "cart")
public class Cart extends AEntity {
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Client	client;
	// TODO I don't know how to do this in sql !
	@Transient //EAGER
	private Map<Product, Integer>	products;
	
	public Cart() {
		this.products = new HashMap<Product, Integer>();
	}	

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return("Cart belonging to " + (this.client == null ? "an unknown client" : this.client.getFullName()));
		//TODO add cart contents
	}

}
