/**
 * 
 */
package jcsi.orm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author kapous_c
 *
 */

@Entity
@Table(name = "cart")
public class Cart extends AEntity {
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Client	client;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cart")
	private Set<Content> content;
	@Column(name = "paid")
	private String paid;
	
	public Cart() {
		this.content = new HashSet<Content>();
		this.paid = "false";
	}	

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addContent(Content c) {
		if (this.content.contains(c)) {
			this.content.remove(c);
		}
		this.content.add(c);
		c.setCart(this);
	}
	
	public void removeContent(Content c) {
		this.content.remove(c);
	}
	
	public boolean isPaid() {
		return (this.paid == "true");
	}

	public void setPaid(boolean paid) {
		this.paid = (paid ? "true" : "false");
	}


	@Override
	public String toString() {
		return("Cart containing " + this.content.size() + " item(s) : " + this.content.toString()
				+ " command paid : " + this.paid + "\n");
	}

}
