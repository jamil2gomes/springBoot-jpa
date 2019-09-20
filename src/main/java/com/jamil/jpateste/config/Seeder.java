package com.jamil.jpateste.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamil.jpateste.domain.Category;
import com.jamil.jpateste.domain.Order;
import com.jamil.jpateste.domain.User;
import com.jamil.jpateste.domain.enuns.OrderStatus;
import com.jamil.jpateste.repositories.CategoryRepository;
import com.jamil.jpateste.repositories.OrderRepository;
import com.jamil.jpateste.repositories.UserRepository;

@Configuration
public class Seeder implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CategoryRepository catRepo;

	@Override
	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		orderRepo.deleteAll();
		catRepo.deleteAll();
	
		Category c1 = new Category(null, "Livros");	
		Category c2 = new Category(null, "Eletronicos");	
		Category c3 = new Category(null, "Games");	
		
		User u1 = new User(null, "Jamil", "jamil@gmail.com", "987654378", "senha");
		User u2 = new User(null, "Josue", "josue@gmail.com", "987654378", "senha1");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.PAID, u1);
		
		repo.saveAll(Arrays.asList(u1, u2));
		orderRepo.saveAll(Arrays.asList(o1,o2,o3));
		catRepo.saveAll(Arrays.asList(c1, c2, c3));
		
	}
	
	

}
