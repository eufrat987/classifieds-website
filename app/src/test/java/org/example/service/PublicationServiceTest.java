package org.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import org.example.model.Publication;
import org.example.repository.PublicationRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PublicationServiceTest {
	@Mock
	private PublicationRepository repository;

	@InjectMocks
	private PublicationService service;

	@Test
	public void whenGetPublication_thenIncrementViews() {
		var publication = new Publication();
		Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(publication));
		publication.setViews(2);
		var result = service.getPublicationAndIncrementViews(1L);
		Assertions.assertEquals(result.getViews(), 3);

	}
}
