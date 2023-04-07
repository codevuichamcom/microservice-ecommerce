package com.funny.code.order.repository;

import com.funny.code.order.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Optional<Inventory> findByProductId(int productId);
}