package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.example.model.Publication; 
import org.example.service.PublicationService; 
import org.example.dto.PublicationRequestDTO;

@RestController
@RequestMapping("api/v1/publications")
public class PublicationController {
	@Autowired
	private PublicationService publicationService;

	@GetMapping("/{id}")
	public Publication getPublicationById(@PathVariable Long id) {
		return publicationService.getPublicationAndIncrementViews(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePublicationById(@PathVariable Long id) {
		publicationService.deletePublication(id); 
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public Publication updatePublicationDescription(@PathVariable Long id, @RequestBody PublicationRequestDTO dto) {
		return publicationService.updatePublication(id, dto);
	}

	@PutMapping
	public Publication createPublication(@RequestBody PublicationRequestDTO dto) {
		return publicationService.createPublication(dto);
	}
}
