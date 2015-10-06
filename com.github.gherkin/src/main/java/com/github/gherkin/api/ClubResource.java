package com.github.gherkin.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.github.gherkin.entity.ClubEntity;
import com.github.gherkin.entity.PersonEntity;
import com.github.gherkin.service.ClubService;

@Path("/Clubs")
public class ClubResource {
	
	@Inject
	ClubService clubService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ClubEntity getClub(@PathParam("id") Long id) {
		return clubService.retrieve(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/0")
	public PersonEntity[] getClubsMember(@PathParam("id") Long id) {
		ClubEntity club = clubService.retrieve(id);
		Long[] memberIDs = club.getMembers();
		
		PersonEntity[] members = new PersonEntity[memberIDs.length];
		
		for(int i = 0; i < memberIDs.length; i++) 
			members[i] = clubService.retrieveMember(memberIDs[i]);

		return members;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addClub(@QueryParam("name") String name, @QueryParam("id") Long id, @QueryParam("member") List<Long> memberIDs) {
		
		ClubEntity club = new ClubEntity();	
		club.setName(name);
		club.setId((long) 1);
		
		for(Long memberID : memberIDs) {
			PersonEntity member = clubService.retrieveMember(memberID);
			club.addMember(member);
		}
		
		clubService.add(club);
	}
}
