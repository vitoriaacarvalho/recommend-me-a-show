package com.vitoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitoria.models.Cats;
@Repository
public interface CatsRepository extends JpaRepository<Cats,Integer> {

}
