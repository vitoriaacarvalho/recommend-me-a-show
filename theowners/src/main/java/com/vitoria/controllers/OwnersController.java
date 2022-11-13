package com.vitoria.controllers;

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

import com.vitoria.models.Owner;
import com.vitoria.services.OwnersService;

@RequestMapping("/owners")
@RestController
public class OwnersController {
	
	@Autowired
	private OwnersService service;
	
	@GetMapping
	public ResponseEntity<List<Owner>> findAll(){
		List<Owner> owners=service.findAll();
		return ResponseEntity.ok().body(owners);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<Owner>> findById(@PathVariable Integer id){
		Optional<Owner> owner=service.findById(id);
		return ResponseEntity.ok().body(owner);
	}
	
	@PostMapping(value="/{id}")
	public ResponseEntity<Owner> save(@RequestBody Owner owner) {
		service.insert(owner);
		return ResponseEntity.ok().body(owner);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Owner> update(@PathVariable Integer id, @RequestBody Owner owner){
		owner=service.update(id, owner);
		return ResponseEntity.ok().body(owner);
	}
}
