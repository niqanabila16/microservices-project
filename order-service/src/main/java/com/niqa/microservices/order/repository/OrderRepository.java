package com.niqa.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niqa.microservices.order.model.Order;

public interface OrderRepository extends JpaRepository <Order, Long>{
    
}
