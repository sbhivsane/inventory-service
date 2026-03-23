package com.equipment.rental_system.inventory_service.repository;

import com.equipment.rental_system.inventory_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
