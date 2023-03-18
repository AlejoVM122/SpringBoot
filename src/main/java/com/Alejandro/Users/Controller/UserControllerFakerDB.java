/**
 * 
 */
package com.Alejandro.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Alejandro.Users.Entities.User;
import com.Alejandro.Users.Servicios.UserServices;
import com.Alejandro.Users.Servicios.UserServicesDB;

import jakarta.websocket.server.PathParam;

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
	 public ResponseEntity<Page<User>>getUsers(@RequestParam("page")int page,@RequestParam("size") int size){
		return new ResponseEntity<Page<User>>(service.gList(page, size),HttpStatus.OK);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser (@PathVariable("id") Integer id){
		
		return new ResponseEntity<User>(service.getUSerById(id),HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> getUserbyNAME (@PathVariable("username") String username){
		
		return new ResponseEntity<>(service.getusername(username), HttpStatus.OK);
	}
}
