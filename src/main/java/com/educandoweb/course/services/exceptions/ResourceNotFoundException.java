package com.educandoweb.course.services.exceptions;


//Exceção personalizada usada quando um recurso não é encontrado,
//por exemplo quando buscamos um usuário por ID e ele não existe.
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
		
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id "+ id);
	}
	
}
