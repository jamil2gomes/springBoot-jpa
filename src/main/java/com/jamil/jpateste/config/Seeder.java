package com.jamil.jpateste.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jamil.jpateste.domain.Category;
import com.jamil.jpateste.domain.Order;
import com.jamil.jpateste.domain.OrderItem;
import com.jamil.jpateste.domain.Product;
import com.jamil.jpateste.domain.User;
import com.jamil.jpateste.domain.enuns.OrderStatus;
import com.jamil.jpateste.repositories.CategoryRepository;
import com.jamil.jpateste.repositories.OrderItemRepository;
import com.jamil.jpateste.repositories.OrderRepository;
import com.jamil.jpateste.repositories.ProductRepository;
import com.jamil.jpateste.repositories.UserRepository;

@Configuration
public class Seeder implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private ProductRepository proRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;

	@Override
	public void run(String... args) throws Exception {
		
		
		//------------------------  USERS ----------------------------------------
		
		User u1 = new User(null, "Jamil", "jamil@gmail.com", "987654378", "senha");
		User u2 = new User(null, "Josue", "josue@gmail.com", "987654378", "senha1");
		
		userRepo.saveAll(Arrays.asList(u1, u2));
		
		//------------------------ PEDIDOS ----------------------------------------
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.PAID, u1);
		
		orderRepo.saveAll(Arrays.asList(o1,o2,o3));
		
		//------------------------ CATEGORIAS -------------------------------------
		Category c1 = new Category(null, "Livros");	
		Category c2 = new Category(null, "Eletronicos");	
		Category c3 = new Category(null, "Games");	
		
		catRepo.saveAll(Arrays.asList(c1, c2, c3));
		
		//------------------------ PRODUTOS ---------------------------------------
		Product p1 = new Product(null, "The Lord of the Rings", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		Product p2 = new Product(null, "Smart TV", "Cras fringilla convallis sem vel faucibus.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Cras fringilla convallis sem vel faucibus.", 1200.0, "");
		Product p4 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		proRepo.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		//------------------------ RELACIONANDO PRODUTO COM CATEGORIA --------------
		p1.adicionarCategoria(c1);
		p2.adicionarCategoria(c2);
		p2.adicionarCategoria(c3);
		p3.adicionarCategoria(c1);
		p4.adicionarCategoria(c2);
		
		proRepo.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		
		//------------------------ ITEM DO PEDIDO -----------------------------------
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
		OrderItem oi4 = new OrderItem(o3, p4, 2, p3.getPrice());
		
		orderItemRepo.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
				
		
	}
	
	

}
