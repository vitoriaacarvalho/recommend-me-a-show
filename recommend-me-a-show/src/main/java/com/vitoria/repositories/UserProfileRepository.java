package com.vitoria.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoria.models.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{

}
