package com.github.gherkin.service;

import java.util.Collection;

import com.github.gherkin.api.data.Person;

public interface PersonService {

	Person retrieve(Long id);
    Collection<Person> retrieveAll();
	void add(Person person);
	void delete(Person person) throws Exception;
}
