package jcsi.orm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "content", uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "cart_id"}))
public class Content extends AEntity {

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Product product;
	@Column(name = "quantity")
	private int quantity;
	
	public Content() {
		this.quantity = 0;
	}
	
	public Content(Product p, int quantity) {
		this.product = p;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return (this.quantity + " x " + this.product.toString());
	}
}
