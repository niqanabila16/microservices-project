package com.niqa.microservices.inventory.repository;

import com.niqa.microservices.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
    // Inventory findBySkuCode(String skuCode);
}
