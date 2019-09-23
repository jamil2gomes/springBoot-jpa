package com.jamil.jpateste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamil.jpateste.domain.Product;
import com.jamil.jpateste.repositories.ProductRepository;
import com.jamil.jpateste.services.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	
	public Product findById(Long id) {
		
		Product prod = repo.findById(id).orElse(null);
		
		if(prod == null) throw new ObjectNotFoundException("Produto não encontrado no banco de dados");
		
		return prod;
	}
}
