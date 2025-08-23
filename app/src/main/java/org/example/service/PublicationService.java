package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.model.Publication; 
import org.example.repository.PublicationRepository; 
import org.example.exception.PublicationNotFounded;

@Service
public class PublicationService {
	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private PublicationMapper publicationMapper;

	public Publication getPublicationAndIncrementViews(Long id) {
		var publication = publicationRepository.findById(id).getOrElse(null);

		if(publication == null) {
			throw new PublicationNotFounded();
		}

		publication.setViews(publication.getViews() + 1);
		publicationRepository.save(publication);

		return publication;
	}

	public Publication deletePublication(Long id) {
		publicationRepository.deleteById(id);
	}

	public Publication createPublication(PublicationRequestDTO dto) {
		var publication = publicationMapper.toEntity(dto);	
		publicationRepository.save(publication);
		return publication;
	}

	public Publication updatePublication(Long id, PublicationRequestDTO dto) {
		var publication = publicationRepository.findById(id).getOrElse(null);

		if(publication == null) {
			throw new PublicationNotFounded();
		}

		var publication = publicationMapper.toEntity(dto);	
		publication.setId(id);
		publicationRepository.save(publication);
		return publication;
	}
}
