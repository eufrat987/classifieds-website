package org.example.dto;

import jakarta.validation.Validator;
import jakarta.validation.Validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PublicationRequestDTOTest {
	private static Validator validator;

	@BeforeAll
	public static void setUpValidator() {
		var factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void whenDescriptionIsValid_thenNoViolations() {
		var dto = new PublicationRequestDTO("I have car to sell.");
		var violations = validator.validate(dto);
		Assertions.assertTrue(violations.isEmpty());

	}
	@Test
	public void whenDescriptionIsBlank_thenViolation() {
		var dto = new PublicationRequestDTO("");
		var violations = validator.validate(dto);
		Assertions.assertFalse(violations.isEmpty());
	}
	@Test
	public void whenDescriptionIsTooLong_thenViolation() {
		var chars = new char[1001];
		Arrays.fill(chars, 'a');
		var description = new String(chars);
		var dto = new PublicationRequestDTO(description);
		var violations = validator.validate(dto);
		Assertions.assertFalse(violations.isEmpty());
	}
}
