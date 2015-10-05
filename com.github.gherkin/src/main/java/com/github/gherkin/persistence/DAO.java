package com.github.gherkin.persistence;

import java.util.Collection;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface DAO<T> {
	public T retrieve(Long id);
	public Collection<T> retrieveAll();
	public void remove(Long id) throws Exception;
	public void add(T instance);
}
