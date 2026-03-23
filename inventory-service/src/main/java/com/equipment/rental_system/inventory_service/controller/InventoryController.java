package com.equipment.rental_system.inventory_service.controller;


import com.equipment.rental_system.inventory_service.dto.InventoryItem;
import com.equipment.rental_system.inventory_service.services.InventoryService;
import com.equipment.rental_system.inventory_service.util.InventoryUtil;
import com.example.api.InventoryApi;
import com.example.model.CreateInventoryItemRequest;
import com.example.model.InventoryItemResponse;
import com.example.model.InventoryStatus;
import com.example.model.UpdateInventoryItemRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController  implements InventoryApi {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public ResponseEntity<InventoryItemResponse> createInventoryItem(CreateInventoryItemRequest createInventoryItemRequest) {
        InventoryItem inventoryItem = InventoryUtil.mapInventoryItemRequest(createInventoryItemRequest);
        inventoryItem= inventoryService.createInventoryItem(inventoryItem);
        InventoryItemResponse inventoryItemResponse = InventoryUtil.mapInventoryItemResponse(inventoryItem);
       return ResponseEntity.status(HttpStatus.CREATED).body(inventoryItemResponse);
    }

    @Override
    public ResponseEntity<Void> deleteInventoryItem(Long id) {
        inventoryService.deleteInventoryItem(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<InventoryItemResponse>> getAllInventoryItems(InventoryStatus status) {
        List<InventoryItem> allInventoryItems = inventoryService.getAllInventoryItems(InventoryStatus.ACTIVE.getValue());
        List<InventoryItemResponse> inventoryResponse = allInventoryItems.stream().map(InventoryUtil::mapInventoryItemResponse).toList();
       return ResponseEntity.status(HttpStatus.OK).body(inventoryResponse);
    }

    @Override
    public ResponseEntity<InventoryItemResponse> getInventoryItemById(Long id) {
        InventoryItem inventoryItemById = inventoryService.getInventoryItemById(id);
        InventoryItemResponse inventoryItemResponse = InventoryUtil.mapInventoryItemResponse(inventoryItemById);
        return ResponseEntity.status(HttpStatus.OK).body(inventoryItemResponse);
    }

    @Override
    public ResponseEntity<InventoryItemResponse> updateInventoryItem(Long id, UpdateInventoryItemRequest updateInventoryItemRequest) {
        InventoryItem inventoryItem = InventoryUtil.mapInventoryItemRequest(id,updateInventoryItemRequest);
        InventoryItem inventoryItemById = inventoryService.updateInventoryItem(id,inventoryItem);
        InventoryItemResponse inventoryItemResponse = InventoryUtil.mapInventoryItemResponse(inventoryItemById);
        return ResponseEntity.status(HttpStatus.OK).body(inventoryItemResponse);
    }
}
