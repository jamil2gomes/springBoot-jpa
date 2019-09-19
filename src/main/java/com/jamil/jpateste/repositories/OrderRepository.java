package com.jamil.jpateste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamil.jpateste.domain.Order;

public interface OrderRepository  extends JpaRepository<Order, Long>{

}
