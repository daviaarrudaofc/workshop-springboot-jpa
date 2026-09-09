package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController // Essa classe vai receber requisições HTTP e devolver respostas
@RequestMapping(value = "/users")  //Essa define o caminho (rota) principal desse controller:
//http://localhost:8080/users tipo isso vamos dizer assim
public class UserResource {
	//Serve para disponibilizar um recurso web correspondente a entidade User
	
	@GetMapping //Quando chegar uma requisição HTTP GET para /users, execute este método
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);//Retorne uma resposta HTTP 200 OK, contendo u no corpo
	}
	
}
