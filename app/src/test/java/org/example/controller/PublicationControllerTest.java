package org.example.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.example.repository.PublicationRepository;
import org.example.model.Publication;
import java.util.Optional;

@WebMvcTest(PublicationController.class)
public class PublicationControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PublicationRepository publicationRepository; 
	
	@Test
	public void testGetPublicationById() throws Exception {
		Mockito.when(publicationRepository.findById(Mockito.any())).thenReturn(Optional.of(new Publication()));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/publications/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testDeletePublicationById() throws Exception {
		Mockito.when(publicationRepository.findById(Mockito.any())).thenReturn(Optional.of(new Publication()));

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/publications/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testCreatePublication() throws Exception {
		Mockito.when(publicationRepository.findById(Mockito.any())).thenReturn(Optional.of(new Publication()));

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/publications/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testUpdatePublicationById() throws Exception {
		Mockito.when(publicationRepository.findById(Mockito.any())).thenReturn(Optional.of(new Publication()));

		mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/publications/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
