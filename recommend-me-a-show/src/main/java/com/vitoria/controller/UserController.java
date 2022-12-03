package com.vitoria.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitoria.models.User;
import com.vitoria.services.UserServices;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserServices service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users= service.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable Integer id){
		Optional<User> user=service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value="emails/{email}")
	public ResponseEntity<User> doesEmailExist(User user){
		User userExists=service.doesEmailExist(user);
		return ResponseEntity.ok().body(userExists);
	}
	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){
		user=service.insert(user);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@PutMapping(value="/updateName/{id}")
	public ResponseEntity<User> updateName(@PathVariable Integer id, @RequestBody User user){
		User updatedUser=service.updateName(id, user);
		return ResponseEntity.ok().body(updatedUser);
	}
	
	@PutMapping(value="/updatePassword/{id}")
	public ResponseEntity<User> updatePassword(@PathVariable Integer id, @RequestBody User user){
		User updatedPassword=service.updatePassword(id, user);
		return ResponseEntity.ok().body(updatedPassword);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<User> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
