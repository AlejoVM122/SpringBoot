/**
 * 
 */
package com.Alejandro.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alejandro.Users.Entities.User;
import com.Alejandro.Users.Servicios.UserServices;
import com.Alejandro.Users.Servicios.UserServicesDB;

/**
 * @author Alejandro
 *
 */
@RestController
@RequestMapping("/usuario")
public class UserControllerFakerDB {

	@Autowired
	private UserServicesDB service;
	
	@GetMapping
	 public ResponseEntity<List<User>>getUsers(){
		return new ResponseEntity<List<User>>(service.gList(),HttpStatus.OK);
	}
}
