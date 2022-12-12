package com.vitoria.controller;

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

import com.vitoria.dto.ResponseDto;
import com.vitoria.dto.user.SignInDto;
import com.vitoria.dto.user.SignInResponseDto;
import com.vitoria.dto.user.SignUpDto;
import com.vitoria.models.User;
import com.vitoria.repositories.TheUserRepository;
import com.vitoria.service.UserService;

@RestController
@RequestMapping(value="/users", produces="application/json")
public class UserController {
	
	@Autowired
	private TheUserRepository repo;
	@Autowired
	private UserService userService;
	
	
	@PostMapping(value="/signup")
	public ResponseDto signUp(@RequestBody SignUpDto signUpDto) {
		return userService.signUp(signUpDto);
	}
	
	@PostMapping(value="/signin")
	public SignInResponseDto signIn(@RequestBody SignInDto signInDto) {
		return userService.signIn(signInDto);
	}
	
	
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
	
	@PutMapping(value="/updateName/{id}")
	public ResponseEntity<User> updateName(@PathVariable Integer id, @RequestBody User user){
		User updatedName=repo.findById(id).get();
		updatedName.setName(user.getName());
		repo.save(updatedName);
		return ResponseEntity.ok().body(updatedName);
	}
	
	@PutMapping(value="/updatePassword/{id}")
	public ResponseEntity<User> updatePassword(@PathVariable Integer id, @RequestBody User user){
		User updatedPassword=repo.findById(id).get();
		updatedPassword.setPassword(user.getPassword());
		repo.save(updatedPassword);
		return ResponseEntity.ok().body(updatedPassword);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<User> delete(@PathVariable Integer id){
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
