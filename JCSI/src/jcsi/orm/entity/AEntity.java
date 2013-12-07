package jcsi.orm.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AEntity {
	
	@Id
	@Column(name = "id")
	private long	id;

	public long getId() {
		return this.id;
	}
	
	@Override
	public abstract String toString();
}
