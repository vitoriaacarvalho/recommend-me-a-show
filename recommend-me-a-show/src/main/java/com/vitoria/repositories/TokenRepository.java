package com.vitoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitoria.models.AuthenticationToken;
import com.vitoria.models.User;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
	AuthenticationToken findByUser(User user);
}
