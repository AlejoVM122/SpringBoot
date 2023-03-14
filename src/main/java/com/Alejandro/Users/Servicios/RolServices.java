package com.Alejandro.Users.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alejandro.Users.Entities.Rol;
import com.Alejandro.Users.Repository.RolRepository;

@Service
public class RolServices {
	
	@Autowired
	private RolRepository rolRepository;

	public List<Rol> getRol(){
	 return rolRepository.findAll();}                        
	
	
	public Rol createRol (Rol rol) {
	return rolRepository.save(rol);
	} 
}
