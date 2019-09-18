package com.jamil.jpateste.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jamil.jpateste.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	public ResponseEntity<User>findAll(){
		User u = new User(1L, "Jamil", "jamil@gmail.com", "987654378", "senha");
		
		return ResponseEntity.ok().body(u);
	}

}
