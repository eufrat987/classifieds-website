package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import jakarta.persistence.OptimisticLockException;

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

	@Retryable(
		value = ObjectOptimisticLockingFailureException.class,
		maxAttempts = 5,
		backoff = @Backoff(delay = 100, multiplier = 2)
	)
	@Transactional
	public Publication getPublicationAndIncrementViews(Long id) {
		var publication = publicationRepository.findById(id).orElse(null);

		if(publication == null) {
			throw new PublicationNotFoundedException();
		}

		publication.setViews(publication.getViews() + 1);
		publicationRepository.save(publication);

		return publication;
	}

	public void deletePublication(Long id) {
		publicationRepository.deleteById(id);
	}

	public Publication createPublication(PublicationRequestDTO dto) {
		var publication = publicationMapper.toEntity(dto);	
		publicationRepository.save(publication);
		return publication;
	}

	public Publication updatePublication(Long id, PublicationRequestDTO dto) {
		var publication = publicationRepository.findById(id).orElse(null);

		if(publication == null) {
			throw new PublicationNotFoundedException();
		}

		publication.setDescription(dto.getDescription());
		publicationRepository.save(publication);
		return publication;
	}
}
