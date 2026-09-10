package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.OrderService;

@RestController // Essa classe vai receber requisições HTTP e devolver respostas
@RequestMapping(value = "/orders")  //Essa define o caminho (rota) principal desse controller:
//http://localhost:8080/users tipo isso vamos dizer assim
public class OrderResource {
	//Serve para disponibilizar um recurso web correspondente a entidade User
	@Autowired
	private OrderService service;
	
	@GetMapping //Quando chegar uma requisição HTTP GET para /users, execute este método
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);//Retorne uma resposta HTTP 200 OK, contendo u no corpo
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
