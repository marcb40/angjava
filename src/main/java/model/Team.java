package model;

import java.util.List;

public class Team {

	private List<Person> players;

	
	public Team() {
		super();
	}

	public Team(List<Person> players) {
		super();
		this.players = players;
	}

	public List<Person> getPlayers() {
		return players;
	}

	public void setPlayers(List<Person> players) {
		this.players = players;
	}
	
	
	
}
