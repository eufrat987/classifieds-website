package org.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.example.controller.PublicationController;
import org.example.exception.PublicationNotFoundedException;

import java.util.HashMap;

@ControllerAdvice(assignableTypes = PublicationController.class)
public class PublicationControllerAdvice {

	@ExceptionHandler(PublicationNotFoundedException.class)
	public ResponseEntity<String> handleNotFoundedException(PublicationNotFoundedException ex) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleConstrainViolation(MethodArgumentNotValidException ex) {
		var errors = new HashMap<String, String>();
		for (var error: ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
		
	}
}
