package org.example.mapper;

import org.springframework.stereotype.Component;

import org.example.model.Publication;
import org.example.dto.PublicationRequestDTO;

@Component
public class PublicationMapper {
	public Publication toEntity(PublicationRequestDTO dto) {
		return new Publication();
	}
}
