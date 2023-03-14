package com.Alejandro.Users.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HOLA")
public class Controller {

	@GetMapping
	public String HolaMundoHTTP (){
		return "Hola acá podemos hacerlo todo, solo tenemos que saber como";
	
	}
}
