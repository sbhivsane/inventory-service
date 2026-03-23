package com.equipment.rental_system.inventory_service.entity;


import com.equipment.rental_system.inventory_service.enums.InventoryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long categoryId;
    private String serialNumber;
    @Enumerated(EnumType.STRING)
    private InventoryStatus status;



}
