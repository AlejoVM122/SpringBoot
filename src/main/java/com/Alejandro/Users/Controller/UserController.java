package com.Alejandro.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alejandro.Users.Servicios.UserServices;
import com.Alejandro.Users.model.User;

@RestController
//definición de mi recurso
@RequestMapping("/users")
public class UserController {
	
	//inyeción del servicio que tenemos creado en UserServices
	@Autowired
	private UserServices userServices;
	
	@GetMapping
	//Ejecutado a traves de un http y un recurso como el que colocamos arriba de RequestMapping -handler methods
	public ResponseEntity<List<User>> get (){
	
		return new ResponseEntity<List<User>>(userServices.getUsers(),HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{userName}")
	public ResponseEntity<User> getUserByUsername (@PathVariable("userName") String username){
		
		return new ResponseEntity<User>(userServices.obtenerUser(username),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser (@RequestBody User user){
	return new ResponseEntity<User> (userServices.CreateUser(user),HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "/{userName}")
	public ResponseEntity<User> UpdateUser(@PathVariable("userName") String username,@RequestBody User user){
		return new ResponseEntity<User>(userServices.updateUser(user, username), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{userName}")
	public ResponseEntity<Void> deleteUser ( @PathVariable("userName")String username,User user ){
		userServices.deleteUser(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
