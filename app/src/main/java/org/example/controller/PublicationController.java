package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.example.model.Publication; 
import org.example.repository.PublicationRepository; 

import java.util.Map;

@RestController
@RequestMapping("api/v1/publications")
public class PublicationController {
	@Autowired
	private PublicationRepository publicationRepository;

	@GetMapping("/{id}")
	public Publication getPublicationById(@PathVariable Long id) {
		return publicationRepository.findById(id).get();
	}

	@DeleteMapping("/{id}")
	public void deletePublicationById(@PathVariable Long id) {
		publicationRepository.deleteById(id);
		return; 
	}

	@PatchMapping("/{id}")
	public Publication updatePublicationDescription(@PathVariable Long id, @RequestBody Map<String, String> updates) {
		var publication = publicationRepository.findById(id);

		if (publication.isEmpty()) {
			return null;
		}

		var existingPublication = publication.get();
		existingPublication.setDescription(updates.get("description")); 
		publicationRepository.save(existingPublication);
		return existingPublication;
	}

	@PutMapping
	public Publication createPublication(@RequestBody Map<String, String> newPublication) {
		var publication = new Publication();
		publication.setDescription(newPublication.get("description")); 
		publicationRepository.save(publication);
		return publication;
	}

}
