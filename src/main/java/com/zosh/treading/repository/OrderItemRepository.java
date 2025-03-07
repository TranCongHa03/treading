package com.zosh.treading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.treading.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

    
}
