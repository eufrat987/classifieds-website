package org.example.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PublicationRepositoryIntegrationTest {
	@Autowired
	private PublicationRepository publicationRepository;

	@Test
	public void whenCountAllPublications_thenReturnTwo() {
		var numberOfPublications = publicationRepository.count();
		Assertions.assertEquals(numberOfPublications, 2);
	}
}
