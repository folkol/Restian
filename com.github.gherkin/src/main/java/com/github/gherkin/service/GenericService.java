package com.github.gherkin.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.gherkin.api.data.Person;
import com.github.gherkin.entity.PersonEntity;
import com.github.gherkin.persistence.DAO;

public abstract class GenericService<T, T2> {
	
	public T2 retrieve(DAO<T> Dao, Long id) {
//		Person persson = new Person();
//		persson.setId(1);
//		persson.setName("" + id);
//		return persson;
		T entity = Dao.retrieve(id);
//		if(entity == null) {
//			Person persson = new Person();
//			persson.setId((long) 1);
//			persson.setName("null from DAO");
//			return persson;
//		}
		T2 data = entityToData(entity);
		return data;
	}

	
	protected abstract T2 entityToData(T entity);
	protected abstract T dataToEntity(T2 data);

	
	public void add(T2 data, Long id) {}
}
