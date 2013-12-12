package service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Person;
import model.Team;
import service.TeamService.TeamType;

@Path("/person")
public class PlayerService {

	public static Map<Integer, Person> players = new HashMap<Integer, Person>();
	
	static {
		players.put(1, new Person(1, "Sidney", "Crosby", TeamType.PENGUINS));
		players.put(2, new Person(2, "Evgeni", "Malkin", TeamType.PENGUINS));
		players.put(3, new Person(3, "Chris", "Kunitz", TeamType.PENGUINS));
	}
	
	
	@GET
	@Path("player/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(@PathParam("id") Integer id) {
		return players.get(id);
	}
	
	@POST
	@Path("player/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Team addPerson(Person person) {
		person.setId(getNextId());
		players.put(person.getId(), person);
		
		return (new TeamService()).getTeam(person.getTeamName().toString());
	}
	
	
	public Integer getNextId() {
		Integer index = 0;
		for (Integer i : players.keySet()) {
			index = i > index ? i : index;
		}
		return index + 1;
	}
}
