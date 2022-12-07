package com.vitoria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitoria.models.User;
import com.vitoria.repositories.TheUserRepository;

@RestController
@RequestMapping(value="/users", produces="application/json")
public class UserController {
	
	@Autowired
	private TheUserRepository repo;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users= repo.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Integer id){
		Optional<User> user=repo.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value="emails/{email}")
	public ResponseEntity<User> doesEmailExist(User user){
		String email=user.getEmail();
		doesUserExist(email);
		return ResponseEntity.ok().body(user);
	}
	
	private boolean doesUserExist(String email) {
		if (repo.findByEmail(email) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody User user){
		User entity=repo.findByEmail(user.getEmail());
		if(entity==null) {
			repo.save(entity);
			return ResponseEntity.status(HttpStatus.CREATED).body("USER SUCESSFULLY CREATED");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("AN USER ASSOCIATED TO THIS EMAIL ALREADY EXISTS");
		}	
	}
	
	@PutMapping(value="/updateName/{id}")
	public ResponseEntity<User> updateName(@PathVariable Integer id, @RequestBody User user){
		User updatedName=user;
		updatedName.setName(user.getName());
		repo.save(updatedName);
		return ResponseEntity.ok().body(updatedName);
	}
	
	@PutMapping(value="/updatePassword/{id}")
	public ResponseEntity<User> updatePassword(@PathVariable Integer id, @RequestBody User user){
		User updatedPassword=user;
		updatedPassword.setName(user.getPassword());
		repo.save(updatedPassword);
		return ResponseEntity.ok().body(updatedPassword);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<User> delete(@PathVariable Integer id){
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
