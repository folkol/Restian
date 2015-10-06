package com.github.gherkin.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.gherkin.entity.ClubEntity;
import com.github.gherkin.entity.PersonEntity;
import com.github.gherkin.persistence.DAO;

@Singleton
public class ClubServiceImpl extends GenericService<ClubEntity>implements ClubService {


	@Inject
	private void setDAO(DAO<ClubEntity> dao) {
	this.dao = dao;
	}
	
	@Inject
	PersonService personService;

	public PersonEntity retrieveMember(Long id) {
		PersonEntity person = personService.retrieve(id);
		return person;
	}	
}
