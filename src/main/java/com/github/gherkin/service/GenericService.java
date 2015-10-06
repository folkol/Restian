package com.github.gherkin.service;

import java.util.Collection;

import com.github.gherkin.persistence.DAO;

public abstract class GenericService<T> {
	protected DAO<T> dao;
	
	public T retrieve(Long id) {
		T entity = dao.retrieve(id);
		
		return entity;
	}
		
	public void add(T entity) {
		dao.add(entity);
	}
	
	public Collection<T> retrieveAll() {
		Collection<T> entityCollection = dao.retrieveAll();	
		
		return entityCollection;		
	}

}
