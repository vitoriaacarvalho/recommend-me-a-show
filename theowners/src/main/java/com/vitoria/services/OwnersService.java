package com.vitoria.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoria.models.Owner;
import com.vitoria.repositories.OwnersRepository;
import com.vitoria.services.exceptions.ResourceNotFoundException;

@Service
public class OwnersService {
	@Autowired
	private OwnersRepository repo;
	
	public List<Owner> findAll(){
		return repo.findAll();
	}
	
	public Optional<Owner> findById(Integer id){
		Optional<Owner> owner=repo.findById(id);
		return owner;
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public Owner insert(Owner owner) {
		return repo.save(owner);
	}
	
	
	public Owner update(Integer id, Owner owner) {
		try {
			@SuppressWarnings("deprecation")
			Owner entity=repo.getById(id);
			updateData(entity,owner);
			return repo.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Owner entity, Owner owner) {
		entity.setName(owner.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
