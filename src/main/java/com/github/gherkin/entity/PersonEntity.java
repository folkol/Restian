package com.github.gherkin.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON", schema = "APP")
public class PersonEntity {//implements Serializable {

//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -2403723782179885770L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public PersonEntity(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public PersonEntity() {}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		PersonEntity otherPerson = (PersonEntity) obj;
		if(otherPerson.name == this.name && otherPerson.id == this.id)
			return true;
		else
			return false;
	}
}
