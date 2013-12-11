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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
	private Set<Content> content;
	@Column(name = "paid")
	private boolean paid;
	
	public Cart() {
		this.content = new HashSet<Content>();
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
	}
	
	public void removeContent(Content c) {
		this.content.remove(c);
	}
	
	public boolean isPaid() {
		return this.paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}


	@Override
	public String toString() {
		return("Cart belonging to " + (this.client == null ? "an unknown client" : this.client.getFullName()
				+ "\nContents : " + this.content.toString()));
		//TODO add cart contents
	}

}
