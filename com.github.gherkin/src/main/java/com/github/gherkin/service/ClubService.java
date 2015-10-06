package com.github.gherkin.service;

import com.github.gherkin.entity.ClubEntity;
import com.github.gherkin.entity.PersonEntity;

public interface ClubService {
	public ClubEntity retrieve(Long id);
	public PersonEntity retrieveMember(Long id);
	public void add(ClubEntity club);
}
