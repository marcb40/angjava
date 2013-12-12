package service;

import java.net.URI;

import model.Team;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class TestTeamService {

	
	@Test
	public void testGetPerson() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:8080/angjava/rest/team/players/Penguins");
		Team t = restTemplate.getForObject(uri, Team.class);
		Assert.assertNotNull(t);
		Assert.assertTrue(t.getPlayers().size() >=3);
	}

}
