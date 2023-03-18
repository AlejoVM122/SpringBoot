package com.Alejandro.Users.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Alejandro.Users.model.User;

@Repository
public interface UserRepository extends JpaRepository<com.Alejandro.Users.Entities.User, Integer>{

	
	public Optional<com.Alejandro.Users.Entities.User> findByusername(String username);
	

}
