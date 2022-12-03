package com.vitoria.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoria.models.User;
import com.vitoria.repositories.UserRepository;
import com.vitoria.repositories.exceptions.ResourceNotFoundException;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public Optional<User> findById(Integer id){
		return repo.findById(id);
	}
		
	public User doesEmailExist(User user) {
		String email=user.getEmail();
		repo.findByEmail(email);
		return user;
	}
	
	public User insert(User user) {
		return repo.save(user);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	//changing the username
	public User updateName(Integer id, User user) {
		try {
			@SuppressWarnings("deprecation")
			User entity=repo.getById(id);
			updateName(entity, user);
			return repo.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateName(User entity, User user) {
		entity.setName(user.getName());
	}

	//method to change only the password	
	public User updatePassword(Integer id, User user) {
		try {
			@SuppressWarnings("deprecation")
			User entity=repo.getById(id);
			updatePassword(entity, user);
			return repo.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updatePassword(User entity, User user) {
		entity.setPassword(user.getPassword());
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
