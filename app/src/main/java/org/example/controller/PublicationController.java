package org.example.controller;

import jakarta.validation.Valid;
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

import reactor.core.publisher.Mono;

import org.example.model.Publication; 
import org.example.service.PublicationService; 
import org.example.dto.PublicationRequestDTO;

@RestController
@RequestMapping("api/v1/publications")
public class PublicationController {
	@Autowired
	private PublicationService publicationService;

	@GetMapping("/{id}")
	public Mono<Publication> getPublicationById(@PathVariable @Valid Long id) {
		return publicationService.getPublicationAndIncrementViews(id);
	}

	//@DeleteMapping("/{id}")
	//public ResponseEntity<Void> deletePublicationById(@PathVariable Long id) {
	//	publicationService.deletePublication(id); 
	//	return ResponseEntity.noContent().build();
	//}

	//@PatchMapping("/{id}")
	//public ResponseEntity<Publication> updatePublicationDescription(@PathVariable Long id, @RequestBody @Valid PublicationRequestDTO dto) {
	//	var publication = publicationService.updatePublication(id, dto);
	//	return ResponseEntity.ok(publication);
	//}

	//@PutMapping
	//public ResponseEntity<Publication> createPublication(@RequestBody @Valid PublicationRequestDTO dto) {
	//	var publication = publicationService.createPublication(dto);
	//	return ResponseEntity.ok(publication);
	//}
}
