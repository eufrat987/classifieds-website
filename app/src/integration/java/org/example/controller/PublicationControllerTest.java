package org.example.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.example.service.PublicationService;
import org.example.model.Publication;

@WebMvcTest(PublicationController.class)
public class PublicationControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PublicationService publicationService; 
	
	@Test
	public void testGetPublicationById() throws Exception {
		Mockito.when(publicationService.getPublicationAndIncrementViews(1L)).thenReturn(new Publication());

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/publications/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testDeletePublicationById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/publications/1"))
			.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	public void testCreatePublication() throws Exception {
		Mockito.when(publicationService.createPublication(Mockito.any())).thenReturn(new Publication());

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/publications")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"description\": \"desc\"}"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testUpdatePublicationById() throws Exception {
		Mockito.when(publicationService.updatePublication(Mockito.eq(1L), Mockito.any())).thenReturn(new Publication());

		mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/publications/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"description\": \"new one\"}"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
