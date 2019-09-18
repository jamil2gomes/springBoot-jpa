package com.jamil.jpateste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamil.jpateste.domain.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
