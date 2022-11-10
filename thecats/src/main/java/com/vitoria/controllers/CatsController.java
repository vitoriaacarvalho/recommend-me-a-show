package com.vitoria.controllers;

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

import com.vitoria.models.Cats;
import com.vitoria.services.CatsService;

@RequestMapping(value="/cats")
@RestController
public class CatsController {
	
	@Autowired
	private CatsService service;
	
	@GetMapping
	public ResponseEntity<List<Cats>> findAll(){
		List<Cats> cats=service.findAll();
		return ResponseEntity.ok().body(cats);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<Cats>> findById(@PathVariable Integer id){
		Optional<Cats> cat=service.findById(id);
		return ResponseEntity.ok().body(cat);
	}
	
	@PostMapping(value="/{id}")
	public ResponseEntity<Cats> insert(@RequestBody Cats cat){
		cat=service.insert(cat);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cat.getId()).toUri();
		return ResponseEntity.created(uri).body(cat);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Cats> update(@PathVariable Integer id, @RequestBody Cats cat){
		cat=service.update(id, cat);
		return ResponseEntity.ok().body(cat);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Cats> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
