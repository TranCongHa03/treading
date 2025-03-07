package com.zosh.treading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.treading.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);
}
