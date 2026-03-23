package com.equipment.rental_system.inventory_service.util;

import com.equipment.rental_system.inventory_service.dto.InventoryItem;
import com.equipment.rental_system.inventory_service.entity.Inventory;
import com.equipment.rental_system.inventory_service.enums.InventoryStatus;
import com.example.model.CreateInventoryItemRequest;
import com.example.model.InventoryItemResponse;
import com.example.model.UpdateInventoryItemRequest;

public class InventoryUtil {

    public static Inventory mapToEntity(InventoryItem inventory){
        return Inventory.builder().
                id(inventory.getId())
                .name(inventory.getName())
                .status(inventory.getStatus())
                .categoryId(inventory.getCategoryId())
                .serialNumber(inventory.getSerialNumber())
                .build();
    }

    public static InventoryItem mapToInventoryItem(Inventory inventory){
        return InventoryItem.builder().
                id(inventory.getId())
                .name(inventory.getName())
                .status(inventory.getStatus())
                .categoryId(inventory.getCategoryId())
                .serialNumber(inventory.getSerialNumber())
                .build();
    }

    public static InventoryItem mapInventoryItemRequest(CreateInventoryItemRequest inventory){
        return InventoryItem.builder().
                name(inventory.getName())
                .status(InventoryStatus.valueOf(inventory.getStatus().getValue()))
                .categoryId(inventory.getCategoryId())
                .serialNumber(inventory.getSerialNumber())
                .build();
    }
    public static InventoryItem mapInventoryItemRequest(Long id,UpdateInventoryItemRequest inventory){
        return InventoryItem.builder()
                .id(id)
                .name(inventory.getName())
                .status(InventoryStatus.valueOf(inventory.getStatus().getValue()))
                .categoryId(inventory.getCategoryId())
                .serialNumber(inventory.getSerialNumber())
                .build();
    }

    public static InventoryItemResponse mapInventoryItemResponse(InventoryItem inventory){
        InventoryItemResponse inventoryItemResponse = new InventoryItemResponse();
        inventoryItemResponse.categoryId(inventory.getCategoryId())
                .id(inventory.getId())
                .name(inventory.getName())
                .categoryId(inventory.getCategoryId())
                .status(com.example.model.InventoryStatus.valueOf(inventory.getStatus().name()))
                .serialNumber(inventory.getSerialNumber());
       return inventoryItemResponse;
    }

}
