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

import com.github.gherkin.api.data.Club;
import com.github.gherkin.api.data.Person;
import com.github.gherkin.service.ClubService;

@Path("/Clubs")
public class ClubResource {
	
	@Inject
	ClubService clubService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Club getClub(@PathParam("id") Long id) {
		return clubService.retrieve(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/post")
	public void addClub(@QueryParam("name") String name, @QueryParam("id") Long id, @QueryParam("member") List<Long> memberIDs) {
		
		Club club = new Club();	
		club.setName(name);
		club.setId((long) 1);
		
		for(Long memberID : memberIDs) {
			Person member = clubService.retrieveMember(memberID);
			club.addMember(member);
		}
		
		clubService.add(club);
	}
}
