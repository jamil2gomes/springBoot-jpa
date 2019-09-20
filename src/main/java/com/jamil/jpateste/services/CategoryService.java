package com.jamil.jpateste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamil.jpateste.domain.Category;
import com.jamil.jpateste.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	
	public List<Category> findAll(){
		return repo.findAll();
	}
	
	public Category findById(Long id) {
		
		Category cat = repo.findById(id).orElse(null);
		
		return cat;
	}
}
