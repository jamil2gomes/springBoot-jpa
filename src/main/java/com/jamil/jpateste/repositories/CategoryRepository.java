package com.jamil.jpateste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamil.jpateste.domain.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long>{

}
