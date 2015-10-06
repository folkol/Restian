package com.github.gherkin.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.gherkin.entity.PersonEntity;
import com.github.gherkin.persistence.DAO;

@Singleton
public class PersonServiceImpl extends GenericService<PersonEntity> implements PersonService {

	@Inject
	private void setDAO(DAO<PersonEntity> dao) {
		this.dao = dao;
	}
	
	public void remove(PersonEntity person) throws Exception {
		Long id = person.getId();
		dao.remove(id);
	}
}
