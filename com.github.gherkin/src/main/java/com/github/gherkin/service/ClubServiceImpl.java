package com.github.gherkin.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.gherkin.api.data.Club;
import com.github.gherkin.api.data.Person;
import com.github.gherkin.entity.ClubEntity;
import com.github.gherkin.persistence.DAO;

@Singleton
public class ClubServiceImpl extends GenericService<ClubEntity, Club>implements ClubService {

	@Inject
	DAO<ClubEntity> dao;
	
	@Inject
	PersonService personService;
	
	public Club retrieve(Long id) {
		return retrieve(dao, id);
	}


	public void add(Club data) {
		ClubEntity clubEntity = dataToEntity(data);
		dao.add(clubEntity);
	}

	
	@Override
	protected Club entityToData(ClubEntity entity) {
		Club club = new Club();
		
		club.setId(entity.getId());
		club.setName(entity.getName());
		
		String[] memberIDString;
		Long id;
		Person member;
		memberIDString = entity.getMembers().split(",");
		for(String string : memberIDString) {
			id = Long.parseLong(string);
			member = personService.retrieve(id);
			club.addMember(member);
			
			
		}
		
		return club;
	}

	@Override
	protected ClubEntity dataToEntity(Club data) {
		ClubEntity clubEntity = new ClubEntity();
		
		clubEntity.setId(data.getId());
		clubEntity.setName(data.getName());
		
		Collection<Person> members = data.getMembers();
		String memberIDs = "";
		for(Person member : members)
			memberIDs += member.getId() + ",";
		clubEntity.setMembers(memberIDs);
		
		return clubEntity;
	}


	public Person retrieveMember(Long id) {
		Person person = personService.retrieve(id);
		
		return person;
	}
	
}
