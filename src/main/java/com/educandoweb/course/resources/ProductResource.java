package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController // Essa classe vai receber requisições HTTP e devolver respostas
@RequestMapping(value = "/products")  //Essa define o caminho (rota) principal desse controller:
//http://localhost:8080/Products tipo isso vamos dizer assim
public class ProductResource {
	//Serve para disponibilizar um recurso web correspondente a entidade Product
	@Autowired
	private ProductService service;
	
	@GetMapping //Quando chegar uma requisição HTTP GET para /Products, execute este método
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);//Retorne uma resposta HTTP 200 OK, contendo u no corpo
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
