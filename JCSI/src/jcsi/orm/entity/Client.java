package jcsi.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Client implements IEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long	id;
	@Column(name = "name", unique = true)
	private String	name;
	// private Cart	cart;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
	}

	@Override
	public void loadFull() {
		// TODO Auto-generated method stub
	}

}
