package com.jamil.jpateste.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamil.jpateste.domain.Order;
import com.jamil.jpateste.domain.User;
import com.jamil.jpateste.repositories.OrderRepository;
import com.jamil.jpateste.repositories.UserRepository;

@Configuration
public class Seeder implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		orderRepo.deleteAll();
	
		
		
		User u1 = new User(null, "Jamil", "jamil@gmail.com", "987654378", "senha");
		User u2 = new User(null, "Josue", "josue@gmail.com", "987654378", "senha1");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		repo.saveAll(Arrays.asList(u1, u2));
		
		orderRepo.saveAll(Arrays.asList(o1,o2,o3));
		
	}
	
	

}
