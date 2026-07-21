package com.cognizant.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/{productId}")
    public Map<String, Object> getInventoryStatus(@PathVariable String productId) {
        return Map.of(
                "productId", productId,
                "quantity", 150,
                "inStock", true,
                "service", "inventory-service"
        );
    }
}
