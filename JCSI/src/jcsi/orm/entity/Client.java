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

@Entity
@Table(name = "client")
public class Client extends AEntity {

	@Column(name = "first_name")
	private String	first_name;
	@Column(name = "last_name")
	private String	last_name;
	@Column(name = "email_address")
	private String	email;
	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private Coordinates coordinates;
	@Column(name = "phone_number")
	private String	phone;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id")
	public Set<Cart> carts;
	
	public Client() {
		this.carts = new HashSet<Cart>();
	}
	
	public void addCart(Cart c) {
		c.setClient(this);
		this.carts.add(c);
	}
	
	public void removeCart(Cart c) {
		c.setClient(null);
		this.carts.remove(c);
	}
	
	public String getFirstName() {
		return this.first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return this.last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getFullName() {
		return (this.first_name + " " + this.last_name);
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	public Coordinates getCoordinates() {
		return this.coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	*/

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return("Client : " + this.first_name + " " + this.last_name + "\n"
				+ "Email : " + this.email + "\n"
				+ "Phone : " + this.phone + "\n");
				//+ "Address : " + (this.coordinates != null ? this.coordinates.toString() : ""));
	}

}
