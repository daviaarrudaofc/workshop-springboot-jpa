package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // Essa classe vai receber requisições HTTP e devolver respostas
@RequestMapping(value = "/users")  //Essa define o caminho (rota) principal desse controller:
//http://localhost:8080/users tipo isso vamos dizer assim
public class UserResource {
	//Serve para disponibilizar um recurso web correspondente a entidade User
	@Autowired
	private UserService service;
	
	@GetMapping //Quando chegar uma requisição HTTP GET para /users, execute este método
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);//Retorne uma resposta HTTP 200 OK, contendo u no corpo
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping // Para inserir um novo usuário através de uma requisição HTTP POST
	public ResponseEntity<User> insert(@RequestBody User obj) {// @RequestBody indica que os dados chegam no corpo da requisição em JSON.
			obj = service.insert(obj);							// O Spring desserializa automaticamente esse JSON para um objeto User do Java.
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()	// pega a URL da requisição atual, ex: /users
		            .path("/{id}")										// adiciona /{id} no final da URL
		            .buildAndExpand(obj.getId())						// substitui {id} pelo ID do usuário criado
		            .toUri();											// transforma essa URL em um objeto URI

		    return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();  //o .noConten() vai retornar uma resposta vazia e o codigo HTTP que n tem conteudo é o 204
	}
	
}
