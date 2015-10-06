package com.github.gherkin.service;

import com.github.gherkin.api.data.Club;
import com.github.gherkin.api.data.Person;

public interface ClubService {

	Club retrieve(Long id);
	Person retrieveMember(Long id);
	void add(Club club);
}
