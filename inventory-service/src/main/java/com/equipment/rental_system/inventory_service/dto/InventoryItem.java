package com.equipment.rental_system.inventory_service.dto;

import com.equipment.rental_system.inventory_service.entity.Inventory;
import com.equipment.rental_system.inventory_service.enums.InventoryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InventoryItem {
    private Long id;
    private String name;
    private Long categoryId;
    private String serialNumber;
    private InventoryStatus status;


}
