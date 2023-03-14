package com.Alejandro.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alejandro.Users.Entities.Rol;
import com.Alejandro.Users.Servicios.RolServices;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/rol")
public class RolController {
	
	@Autowired
	private RolServices rolServices; //esto maneja nuestra logica de negocio

	@GetMapping
	public ResponseEntity<List<Rol>> getRols (){
		return new ResponseEntity<List<Rol>>(rolServices.getRol(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rol> createdRol (@RequestBody Rol rol){
		return new ResponseEntity<Rol>(rolServices.createRol(rol),HttpStatus.OK);
	}
}
