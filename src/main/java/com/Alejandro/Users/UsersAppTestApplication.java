package com.Alejandro.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Alejandro.Users.Entities.User;
import com.Alejandro.Users.Repository.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class UsersAppTestApplication implements  ApplicationRunner{

	@Autowired
	private Faker faker;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersAppTestApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		for(int i=0; i< 100;i++) {
			
			User user = new  User();
			
			user.setUsername(faker.artist().name());
			user.setPasword(faker.animal().name());
			user.setProfile(null);
			
			userRepository.save(user);
			
		}
		
	}

	
}
