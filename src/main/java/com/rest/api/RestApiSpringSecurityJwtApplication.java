package com.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.api.model.User;
import com.rest.api.services.UserServiceImpl;

@SpringBootApplication
public class RestApiSpringSecurityJwtApplication implements CommandLineRunner {

	@Autowired
	UserServiceImpl users;
	
	public static void main(String[] args) {
		SpringApplication.run(RestApiSpringSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insert some values to the in-memory user repository
		User user1 = new User(0, "pedroblandim", "123", "pedro@gmail.com", null);
		User user2 = new User(0, "teste", "123qwe", "user@org.com", null);
		User user3 = new User(0, "random-user123", "password", "random@gmail.com", null);
		
		users.insert(user1);
		users.insert(user2);
		users.insert(user3);
	}

}
