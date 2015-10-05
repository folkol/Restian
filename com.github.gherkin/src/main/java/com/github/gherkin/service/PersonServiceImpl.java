package com.github.gherkin.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.gherkin.api.data.Person;
import com.github.gherkin.entity.PersonEntity;
import com.github.gherkin.persistence.DAO;

@Singleton
public class PersonServiceImpl implements PersonService {

	@Inject
	DAO<PersonEntity> dao;
	
	
	public Person retrieve(Long id) {
		PersonEntity personEntity;
		personEntity = dao.retrieve(id);
		
		if(personEntity == null) {
			Person persson = new Person();
			persson.setId((long) 1);
			persson.setName("null from DAO");
			return persson;
		}
		
		Person person = entityToPerson(personEntity);
		return person;
	}

	
	public Collection<Person> retrieveAll() {
		Collection<PersonEntity> entityCollection = dao.retrieveAll();	
		Collection<Person> dataCollection = new ArrayList<Person>();
		Person person;
		for(PersonEntity entity : entityCollection) {
			person = entityToPerson(entity);
			dataCollection.add(person);
		}
		
		return dataCollection;
		
	}
	
	public void remove(Person person) throws Exception {
		Long id = person.getId();
		dao.remove(id);
	}
	
	public Person entityToPerson(PersonEntity personEntity) {
		Person person = new Person();
		
		person.setId(personEntity.getId());
		person.setName(personEntity.getName());
		
		return person;
	}


	public PersonEntity personToEntity(Person person) {
		PersonEntity personEntity = new PersonEntity();
		
		personEntity.setId(person.getId());
		personEntity.setName(person.getName());
		
		return personEntity;
	}
	
	
	public void add(Person person) {
		PersonEntity personEntity;
		personEntity = personToEntity(person);
		dao.add(personEntity);
		
	}


}
