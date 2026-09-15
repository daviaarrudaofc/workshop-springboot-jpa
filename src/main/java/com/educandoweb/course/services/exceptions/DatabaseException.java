package com.educandoweb.course.services.exceptions;

//Exceção personalizada usada para representar erros de banco,
//principalmente quando alguma regra de integridade impede a operação.
public class DatabaseException extends RuntimeException {

 private static final long serialVersionUID = 1L;

 public DatabaseException(String msg) {
     super(msg);
 }
}