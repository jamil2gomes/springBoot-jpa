package com.jamil.jpateste.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String nome) {
		super(nome);
	}
}
