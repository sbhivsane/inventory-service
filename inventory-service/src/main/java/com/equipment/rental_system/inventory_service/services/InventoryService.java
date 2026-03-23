package com.equipment.rental_system.inventory_service.services;

import com.equipment.rental_system.inventory_service.dto.InventoryItem;
import com.equipment.rental_system.inventory_service.entity.Inventory;
import com.equipment.rental_system.inventory_service.repository.InventoryRepository;

import com.equipment.rental_system.inventory_service.util.InventoryUtil;
import com.example.model.UpdateInventoryItemRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    public InventoryItem createInventoryItem(InventoryItem inventoryItemRequest) {
        Inventory inventory = InventoryUtil.mapToEntity(inventoryItemRequest);
        Inventory savedInventoryItem = inventoryRepository.save(inventory);
        return InventoryUtil.mapToInventoryItem(savedInventoryItem);
    }


    public void  deleteInventoryItem(Long id) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        if(optionalInventory.isPresent()){
            inventoryRepository.deleteById(id);
        }else{
            throw new RuntimeException("Item Not Found");
        }

    }


    public List<InventoryItem> getAllInventoryItems(String status) {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories.stream().map(InventoryUtil::mapToInventoryItem).toList();
    }


    public InventoryItem getInventoryItemById(Long id) {
        return inventoryRepository.findById(id).map(InventoryUtil::mapToInventoryItem).orElseThrow(()-> new RuntimeException("sadkja"));

    }


    public InventoryItem updateInventoryItem(Long id, InventoryItem updateInventoryItemRequest) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        if(optionalInventory.isPresent()){
            Inventory inventory = InventoryUtil.mapToEntity(updateInventoryItemRequest);
            Inventory updatedInventoryItem = inventoryRepository.save(inventory);
          return  InventoryUtil.mapToInventoryItem(updatedInventoryItem);
        }else{
            throw new RuntimeException("Item Not Found");
        }
    }

}
