package com.niqa.microservices.order.service;

import com.niqa.microservices.order.dto.OrderRequest;
import com.niqa.microservices.order.model.Order;
import com.niqa.microservices.order.repository.OrderRepository;
import com.niqa.microservices.order.client.InventoryClient;
// import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public void placeOrder(OrderRequest orderRequest) {
        boolean isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + " is not in stock");
        }
    }
}

// @Service
// @RequiredArgsConstructor
// public class OrderService {

//     private final OrderRepository OrderRepository;

//     public void placeOrder(OrderRequest orderRequest) {
//         Order order = new Order();
//         order.setOrderNumber(UUID.randomUUID().toString());
//         order.setPrice(orderRequest.price());  
//         order.setSkuCode(orderRequest.skuCode());  
//         order.setQuantity(orderRequest.quantity());          
//         OrderRepository.save(order);
//     }
// }
