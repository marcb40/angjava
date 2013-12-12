package model;

import service.TeamService.TeamType;

public class Person {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer number = 66;
	private TeamType teamName;
	
	public Person() {
		super();
	}
	
	public Person(Integer id, String firstName, String lastName, TeamType teamName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.teamName = teamName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public TeamType getTeamName() {
		return teamName;
	}

	public void setTeamName(TeamType teamName) {
		this.teamName = teamName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
