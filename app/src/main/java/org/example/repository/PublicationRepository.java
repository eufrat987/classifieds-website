package org.example.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import org.example.model.Publication;

@Repository
public interface PublicationRepository extends ReactiveCrudRepository<Publication, Long> {
}
