package service;

import java.net.URI;

import model.Person;
import model.Team;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import service.TeamService.TeamType;

public class TestPlayerService {

	@Test
	public void testPostPerson() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:8080/angjava/rest/person/player/0");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Person> request = new HttpEntity<Person>(new Person(null, "Phil", "Dunfy", TeamType.PENGUINS), headers);

		Team penguins = restTemplate.postForObject(uri, request, Team.class);
		Assert.assertNotNull(penguins);
		Assert.assertTrue(penguins.getPlayers().size() > 3);
		
		boolean foundPhil = false;
		for (Person player : penguins.getPlayers()) {
			if (player.getFirstName().equals("Phil")) foundPhil = true;
		}
		
		Assert.assertTrue(foundPhil);
	}
	
	@Test
	public void testGetPerson() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:8080/angjava/rest/person/player/1");
		Person p = restTemplate.getForObject(uri, Person.class);
		Assert.assertNotNull(p);
	}


}
