package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import lombok.Getter;

@Getter
public class PublicationRequestDTO {

	@NotBlank
	@Size(max=1000, message="Description cannot be longer that 1000 characters")
	private String description;
}
