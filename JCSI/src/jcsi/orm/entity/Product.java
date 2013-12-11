package jcsi.orm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "product", uniqueConstraints = @UniqueConstraint(columnNames = {"product_name"}))
public class Product extends AEntity {

	@Column(name = "product_name")
	private String	name;
	@Column(name = "price")
	private double	price;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Category	category;

	public Product() {
		// Do nothing
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return (this.name + " - " + this.price + "$"
				+ " (" + (this.category != null ? this.category.getName() : "-") + ")");
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
