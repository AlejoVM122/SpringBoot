package com.Alejandro.Users.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;

import com.Alejandro.Users.Entities.Rol;
import com.Alejandro.Users.Repository.RolRepository;

@Service
public class RolServices {

	@Autowired
	private RolRepository rolRepository;


	
	public List<Rol> getRol (){
		return rolRepository.findAll();
	}

	
	public Rol createRol (Rol rol) {
		return rolRepository.save(rol);
		
	}
	public Rol updateRol(Integer rolId,Rol rol) {
		
		Optional<Rol> findById = rolRepository.findById(rolId);
	
		if(findById.isPresent()) {
			return rolRepository.save(rol);
		}else {
			throw new ResponseStatusException(HttpStatus.FOUND,String.format("Role id no existe",rolId));
		}
	}
	
	
	public void deleteRol (Integer id){
		Optional<Rol> findById = rolRepository.findById(id);
		if(findById.isPresent()) {
			rolRepository.deleteById(id);
		}else {
			throw new ResponseStatusException(HttpStatus.FOUND,String.format("Role id no existe",id));
		}
		
	}

}
