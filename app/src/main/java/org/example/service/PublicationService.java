package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
//import org.springframework.orm.ObjectOptimisticLockingFailureException;
import jakarta.persistence.OptimisticLockException;

import reactor.core.publisher.Mono;

import org.example.dto.PublicationRequestDTO; 
import org.example.model.Publication; 
import org.example.mapper.PublicationMapper; 
import org.example.repository.PublicationRepository; 
import org.example.exception.PublicationNotFoundedException;

@Service
public class PublicationService {
	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private PublicationMapper publicationMapper;
	@Autowired
	private TransactionalOperator transactionalOperator;

	//@Retryable(
	//	value = ObjectOptimisticLockingFailureException.class,
	//	maxAttempts = 5,
	//	backoff = @Backoff(delay = 100, multiplier = 2)
	//)
	public Mono<Publication> getPublicationAndIncrementViews(Long id) {
		return publicationRepository.findById(id)
			.flatMap(publication -> {
				publication.setViews(publication.getViews() + 1);
				return publicationRepository.save(publication);
			})
			.as(transactionalOperator::transactional);
	}

	//public void deletePublication(Long id) {
	//	publicationRepository.deleteById(id);
	//}

	//public Publication createPublication(PublicationRequestDTO dto) {
	//	var publication = publicationMapper.toEntity(dto);	
	//	publication = publicationRepository.save(publication);
	//	return publication;
	//}

	//public Publication updatePublication(Long id, PublicationRequestDTO dto) {
	//	var publication = publicationRepository.findById(id).orElseThrow(() -> new PublicationNotFoundedException());
	//	publication.setDescription(dto.getDescription());
	//	return publication;
	//}
}
