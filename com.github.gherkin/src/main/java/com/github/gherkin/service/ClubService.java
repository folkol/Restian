package com.github.gherkin.service;

import com.github.gherkin.api.data.Club;
import com.github.gherkin.api.data.Person;

public interface ClubService {
	public Club retrieve(Long id);
	public Person retrieveMember(Long id);
	public void add(Club club);
}
