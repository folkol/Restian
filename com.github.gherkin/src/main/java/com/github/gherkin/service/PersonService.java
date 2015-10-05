package com.github.gherkin.service;

import java.util.Collection;

import com.github.gherkin.api.data.Person;
import com.github.gherkin.entity.PersonEntity;

public interface PersonService {
	public Person retrieve(Long id);
	public Collection<Person> retrieveAll();
	public void add(Person person);
	public void remove(Person person) throws Exception;
	public Person entityToPerson(PersonEntity personEntity);
	public PersonEntity personToEntity(Person person);
}
