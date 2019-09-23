package com.jamil.jpateste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamil.jpateste.domain.User;
import com.jamil.jpateste.repositories.UserRepository;
import com.jamil.jpateste.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(Long id) {
		
		User user = repo.findById(id).orElse(null);
		
		if(user == null) throw new ObjectNotFoundException("Usuário não encontrado no banco de dados");
		return user;
	}
}
