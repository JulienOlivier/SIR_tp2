package fr.istic.tpjpa.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Heater extends SmartDevice{
	
	private String name;

	
	@Id
	@GeneratedValue
	public Long getId(){
		return super.getId();
	}
	public void setId(Long id){
		super.setId(id);
	}
	
	public Heater(){
		super();
	}
}
