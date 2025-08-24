package org.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.example.controller.PublicationController;
import org.example.exception.PublicationNotFoundedException;

@ControllerAdvice(assignableTypes = PublicationController.class)
public class PublicationControllerAdvice {

	@ExceptionHandler(PublicationNotFoundedException.class)
	public ResponseEntity<String> handleNotFoundedException(PublicationNotFoundedException ex) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
