package org.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Assertions;

import org.example.service.PublicationService;
import org.example.model.Publication;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PublicationControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void whenGetRequest_thenResponseWithPublication() throws Exception {
		var response = restTemplate.getForEntity("/api/v1/publications/1", Publication.class);

		Assertions.assertEquals(response.getBody().getDescription(), "text1");
	}
}
