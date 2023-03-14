package com.Alejandro.Users.Servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Alejandro.Users.model.User;
import com.github.javafaker.Faker;

import jakarta.annotation.PostConstruct;

@Service
public class UserServices {

	@Autowired
	private Faker faker;
	
	
	/**
	 * Acá voy a poner el codigo para mi servicio
	 */
	
	private List<User> users = new ArrayList<>(); //este la vamos a usar como base de datos, Este va a ser el CRUD
	
    @PostConstruct
	public void init () {
    	
    	
    	//acá la lista de usuarios la vamos a llenar usando el faker que me sirve para llenar datos y con un for creamos 100 registros de una
    	for(int i=0;i<100;i++) {
    		users.add(new User(faker.funnyName().name(), faker.dragonBall().character(), faker.name().lastName()));        	
    	}
	}

	public List<User> getUsers() {
		return users;
	}
    
	public User getUserByName (String username){
	
		return users.stream().filter(u -> u.getUserName().equals(username)).findAny()
	.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,String.format("User %s not found", username)));
	}
	
	public User obtenerUser (String username ){
		
		try {
			
			User usuarioEncontrado= new User(); 
				
			for	(int i=0;i<users.size();i++) {
				
				if(users.get(i).userName.equals(username)){

					return usuarioEncontrado = users.get(i);		
					}
				}
		}catch (ResponseStatusException e) {
			e.getMessage();	
		}
		return null;
	}
	
	public User CreateUser (User user) {
	
		
		if( users.stream().anyMatch(u -> u.getUserName().equals(user.getUserName()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					String.format("user %s already exists" , user.getUserName()));
		}
		
		users.add(user);
		return user;
	}
	public User updateUser (User user,String userName) {
		User userToBeUpdate =  getUserByName(userName);
		userToBeUpdate.setNickName(user.getNickName());
		userToBeUpdate.setPassword(user.password);
		userToBeUpdate.setUserName(user.userName);
		
		return userToBeUpdate;
	}
	
	public void deleteUser(String username) {
		
		User userByName = getUserByName(username);
		
		users.remove(userByName);
		
	}
    
}
