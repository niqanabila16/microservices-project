package com.niqa.microservices.order.service;

import com.niqa.microservices.order.dto.OrderRequest;
import com.niqa.microservices.order.model.Order;
import com.niqa.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository OrderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());  
        order.setSkuCode(orderRequest.skuCode());  
        order.setQuantity(orderRequest.quantity());          
        OrderRepository.save(order);
    }
}
