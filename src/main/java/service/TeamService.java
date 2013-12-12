package service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Person;
import model.Team;

@Path("/team")
public class TeamService {

	public enum TeamType {
		PENGUINS, PIRATES, STEELERS;
	}
	
	@GET
	@Path("players/{teamName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Team getTeam(@PathParam("teamName") String teamName) {
		TeamType teamType = TeamType.valueOf(teamName.toUpperCase());
		List<Person> players = new ArrayList<Person>();
		for (Person player : PlayerService.players.values()) {
			if (player.getTeamName() == teamType) players.add(player);
		}
		
		return new Team(players);
	}
	
}
