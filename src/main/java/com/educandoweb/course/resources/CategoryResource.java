package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController // Essa classe vai receber requisições HTTP e devolver respostas
@RequestMapping(value = "/categories")  //Essa define o caminho (rota) principal desse controller:
//http://localhost:8080/Categorys tipo isso vamos dizer assim
public class CategoryResource {
	//Serve para disponibilizar um recurso web correspondente a entidade Category
	@Autowired
	private CategoryService service;
	
	@GetMapping //Quando chegar uma requisição HTTP GET para /Categorys, execute este método
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);//Retorne uma resposta HTTP 200 OK, contendo u no corpo
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
