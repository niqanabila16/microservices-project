package com.niqa.microservices.order.repository;

import com.niqa.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long>{
    
}
