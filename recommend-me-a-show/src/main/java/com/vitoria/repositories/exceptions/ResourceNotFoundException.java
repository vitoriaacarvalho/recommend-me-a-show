package com.vitoria.repositories.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("resource not found id " +id);
	}
}
