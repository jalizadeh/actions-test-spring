package com.jalizadeh.GithubActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GithubActionsApplicationTests {
	
	private final String baseURL = "http://localhost"; 
	
	@LocalServerPort
	private int port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	
	@Test
	@DisplayName("Home directory is accessible")
	public void accessHome() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		//headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String>  entity = new HttpEntity<>("",headers);
		ResponseEntity<String> response = restTemplate.getForEntity(getBaseUrl(), String.class, entity);
		
		Assertions.assertEquals(response.getBody(), "welcome to home");
		
	}

	
	private String getBaseUrl() {
		return this.baseURL + ":" + port;
	}
}
