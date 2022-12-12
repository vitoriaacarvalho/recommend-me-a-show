package com.vitoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitoria.models.User;

@Repository 
public interface TheUserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
