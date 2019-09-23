package com.jamil.jpateste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamil.jpateste.domain.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long>{

}
