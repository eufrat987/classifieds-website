package org.example.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PublicationRepositoryTest {
	@Autowired
	private PublicationRepository publicationRepository;

	@Test
	public void testFindAllPublications() {
		var numberOfPublications = publicationRepository.count();

		Assertions.assertEquals(numberOfPublications, 2);
		
	}
}
