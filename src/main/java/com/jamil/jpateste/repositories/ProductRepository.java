package com.jamil.jpateste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamil.jpateste.domain.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
