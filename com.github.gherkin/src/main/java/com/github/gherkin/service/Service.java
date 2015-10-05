package com.github.gherkin.service;

import com.github.gherkin.api.data.Person;

public interface Service<Type> {
	public Type retrieve(Long id);
	public void add(String name, Long id);
}
