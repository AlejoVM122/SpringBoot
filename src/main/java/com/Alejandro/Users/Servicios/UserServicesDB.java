/**
 * 
 */
package com.Alejandro.Users.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	public List<User> gList(){
		return repository.findAll();
		
	}
}
