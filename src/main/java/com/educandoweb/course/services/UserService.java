package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service // registra como um compononente do Spring
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long Id) {
		Optional<User> obj = repository.findById(Id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(Id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	// Tenta deletar o usuário pelo id.
	// Se o recurso não for encontrado, lança ResourceNotFoundException.
	// Se o banco impedir a exclusão por alguma restrição de integridade,
	// lança DatabaseException.
	public void delete(Long id) {
	    if (!repository.existsById(id)) {
	        throw new ResourceNotFoundException(id);
	    }
	    try {
	        repository.deleteById(id);
	    }
	    catch (DataIntegrityViolationException e) {
	        throw new DatabaseException(e.getMessage());
	    }
	}	

	public User update(Long id, User obj) {
		try {
		 User entity = repository.getReferenceById(id);
		 updateData(entity, obj);
		 return repository.save(entity);
		}catch(EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
