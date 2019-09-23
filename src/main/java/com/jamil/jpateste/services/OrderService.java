package com.jamil.jpateste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamil.jpateste.domain.Order;
import com.jamil.jpateste.repositories.OrderRepository;
import com.jamil.jpateste.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	
	public List<Order> findAll(){
		return repo.findAll();
	}
	
	public Order findById(Long id) {
		
		Order order = repo.findById(id).orElse(null);
		if(order == null) throw new ObjectNotFoundException("Pedido não encontrado no banco de dados");
		return order;
	}
}
