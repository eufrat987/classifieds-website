package org.example.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PublicationRepositorySmokeTest {
	@Autowired
	private PublicationRepository publicationRepository;

	@Test
	public void whenCountAllPublication_thenReturnTwo() {
		var numberOfPublications = publicationRepository.count();
		Assertions.assertEquals(numberOfPublications, 2);
	}
}
