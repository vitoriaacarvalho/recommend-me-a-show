package com.vitoria.repositories;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vitoria.models.User;

@Repository 
@Transactional
public interface TheUserRepository extends JpaRepository<User, Integer> {
	
	String findByEmail(@Param("email") String email);

}
