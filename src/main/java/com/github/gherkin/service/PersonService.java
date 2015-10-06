package com.github.gherkin.service;

import java.util.Collection;

import com.github.gherkin.entity.PersonEntity;

public interface PersonService {
	
	public PersonEntity retrieve(Long id);
	public Collection<PersonEntity> retrieveAll();
	public void add(PersonEntity person);
	public void remove(PersonEntity person) throws Exception;	

}
