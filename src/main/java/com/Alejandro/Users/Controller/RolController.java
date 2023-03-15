package com.Alejandro.Users.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Alejandro.Users.Entities.Rol;
import com.Alejandro.Users.Servicios.RolServices;

@RestController
@RequestMapping("/rol")
public class RolController {

	@Autowired
	private RolServices rolServices;
	
	@GetMapping
	public ResponseEntity<List<Rol>> getRoles (){
	return new ResponseEntity<List<Rol>>(rolServices.getRol(),HttpStatus.OK); 
	}

	@PostMapping
	private ResponseEntity<Rol> createRol (@RequestBody Rol rol){
		
		return new ResponseEntity<Rol>(rolServices.createRol(rol), HttpStatus.OK);
	} 
	
	@PutMapping("/{roleId}")
	private ResponseEntity<Rol> UpdateRoles (@PathVariable Integer roleId ,@RequestBody Rol rol){
		
		return new ResponseEntity<Rol>(rolServices.updateRol(roleId,rol), HttpStatus.OK);
	} 

	
	@DeleteMapping("/{roleId}")
	private ResponseEntity<Void> delete (@PathVariable Integer roleId ){
		rolServices.deleteRol(roleId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}


