/**
 * 
 */
package jcsi.orm.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author kapous_c
 *
 */

@Entity
@Table(name = "cart")
public class Cart extends AEntity {
	
	@Column(name = "client_id")
	private long	client_id;
	@Transient
	public Client	client;
	// TODO I don't know how to do this in sql !
	@Transient
	private Map<Product, Integer>	products;
	
	public Cart() {
		this.products = new HashMap<Product, Integer>();
	}	
	
	public long getClient_id() {
		return this.client_id;
	}

	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		System.out.println("CLIENT SETTE A " + client.getId());
		if (client != null) {
			this.client_id = client.getId();
		}
		this.client = client;
	}

	@Override
	public String toString() {
		return("Cart belonging to " + (this.client == null ? "an unknown client" : this.client.getFullName())
				+ " (client id : " + this.client_id + ")");
		//TODO add cart contents
	}

}
