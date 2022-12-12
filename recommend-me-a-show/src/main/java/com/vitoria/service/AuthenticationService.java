package com.vitoria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoria.models.AuthenticationToken;
import com.vitoria.models.User;
import com.vitoria.repositories.TokenRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	private TokenRepository repo;
	
	public void saveConfirmationToken(AuthenticationToken authenticationToken) {
		repo.save(authenticationToken);
	}
	
	public AuthenticationToken getToken(User user) {
		return repo.findByUser(user);
	}
}
