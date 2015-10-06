package com.github.gherkin.api;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.github.gherkin.entity.PersonEntity;
import com.github.gherkin.service.PersonService;

@Path("/Person")
public class PersonResource {
	
	@Inject
	private PersonService personService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<PersonEntity> respond() {
		return personService.retrieveAll();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addPerson(@QueryParam("name") String name, @QueryParam("id") Long id) {
		PersonEntity person = new PersonEntity();
		person.setId(id);
		person.setName(name);
		
		personService.add(person);
		
		return "sucessfully added person with name " + name;
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{id}")
	public String deletePerson(@PathParam("id") Long id) {
		PersonEntity person;
		person = personService.retrieve(id);
		try {
			personService.remove(person);
		} catch (Exception e) {
			e.printStackTrace();
			return "error removing person: " + person.getName();
		}
		
		return "sucessfully removed person: " + person.getName();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public PersonEntity getPersonByID(@PathParam("id") Long id) {
		return personService.retrieve(id);
	}
}
