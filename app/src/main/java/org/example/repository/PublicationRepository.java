package org.example.repository;

import org.springframework.data.repository.CrudRepository;

import org.example.model.Publication;

public interface PublicationRepository extends CrudRepository<Publication, Long> {
}
