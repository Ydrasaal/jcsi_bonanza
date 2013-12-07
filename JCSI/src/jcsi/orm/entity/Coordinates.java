package jcsi.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coordinates")
public class Coordinates extends AEntity {
	
	@Column(name = "address")
	private String	address;
	@Column(name = "city")
	private String	city;
	@Column(name = "country")
	private String	country;

	public Coordinates() {
		// Do nothing
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return(this.address + ", " + this.city + ", " + this.country);
	}

}
