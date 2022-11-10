package com.vitoria.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoria.models.Cats;
import com.vitoria.repositories.CatsRepository;
import com.vitoria.services.exceptions.ResourceNotFoundException;

@Service
public class CatsService {
	
	@Autowired
	private CatsRepository repo;
	
	public List<Cats> findAll(){
		return repo.findAll();
	}
	
	
	public Optional<Cats> findById(Integer id){
		Optional<Cats> cat=repo.findById(id);
		return cat;
	}
	
	public Cats insert(Cats cat) {
		return repo.save(cat);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Cats update(Integer id, Cats cat) {
		try {
			Cats entity=repo.getById(id);
			updateData(entity, cat);
			return repo.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}


	private void updateData(Cats entity, Cats cat) {
		entity.setName(cat.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
