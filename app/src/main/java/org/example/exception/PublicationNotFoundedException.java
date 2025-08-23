package org.example.exception;

public class PublicationNotFoundedException extends RuntimeException {
	public PublicationNotFoundedException() {
	       super("Publication with given id was not founded");
	}	       
}	
