/**
 * 
 */
package com.Alejandro.Users.Servicios;

import java.util.List;
import java.util.Optional;

import org.h2.store.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Alejandro.Users.Entities.User;
import com.Alejandro.Users.Repository.UserRepository;

/**
 * @author Alejandro
 *
 */

@Service
public class UserServicesDB {

	@Autowired
	private UserRepository repository;
	
	
	public org.springframework.data.domain.Page<User> gList(int page, int size){
		
		return repository.findAll(PageRequest.of(page, size));
	}
	
	public User getUSerById (Integer id) {
		
		return repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,String.format("user %d not found ", id)));
	}
	
	public User getusername (String username) {
		return repository.findByusername(username).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,String.format("user %d not found ", username)));
	}
}
