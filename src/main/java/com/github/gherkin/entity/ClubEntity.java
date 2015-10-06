package com.github.gherkin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLUB", schema = "APP")
public class ClubEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String members = "";
	
	
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
	public Long[] getMembers() {
		String[] idString = members.split(",");
		Long[] ids = new Long[idString.length];
		
 		for(int i = 0; i < idString.length; i++)
 			ids[i] = Long.parseLong(idString[i]);
 		
 		return ids;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	
	public void addMember(PersonEntity member) {
		members += member.getId() + ",";
	}
}
