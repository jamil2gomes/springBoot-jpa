package com.jamil.jpateste.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamil.jpateste.domain.User;
import com.jamil.jpateste.repositories.UserRepository;

@Configuration
public class Seeder implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		User u1 = new User(null, "Jamil", "jamil@gmail.com", "987654378", "senha");
		User u2 = new User(null, "Josue", "josue@gmail.com", "987654378", "senha1");
		
		repo.saveAll(Arrays.asList(u1, u2));
		
	}
	
	

}
