package com.educandoweb.course.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;


//Classe usada para padronizar a resposta de erro da API.
//Guarda informações como horário do erro, status HTTP,
//tipo do erro, mensagem e caminho da requisição.
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp; // momento em que o erro aconteceu
	private Integer status;    // código HTTP, ex: 404
	private String error;      // nome/tipo do erro
	private String message;    // mensagem mais detalhada
	private String path;       // rota onde ocorreu o erro
	
	public StandardError() {
		
	}

	public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
