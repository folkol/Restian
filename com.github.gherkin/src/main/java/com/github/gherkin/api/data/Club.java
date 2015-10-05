package com.github.gherkin.api.data;

import java.util.ArrayList;
import java.util.Collection;

public class Club extends Data<Club> {
	private Long id;
	private String name;
	private Collection<Person> members;
	
	public Club() {
		members = new ArrayList<Person>();
	}
	
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
	
	public Collection<Person> getMembers() {
		return members;
	}
	
	public void setMembers(Collection<Person> members) {
		this.members = members;
	}
	
	public void addMember(Person person) {
		members.add(person);
	}
	
	public void removeMember(Person member) {
		members.remove(member);
	}
}
