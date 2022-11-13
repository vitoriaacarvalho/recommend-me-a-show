package com.vitoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitoria.models.Owner;
@Repository
public interface OwnersRepository extends JpaRepository<Owner, Integer>{

}
