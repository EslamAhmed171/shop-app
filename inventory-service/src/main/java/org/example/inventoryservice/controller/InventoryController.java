package org.example.inventoryservice.controller;

import org.example.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam Map<String, String> items){
        Map<String, Integer> itemsWithQuantity = items.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, value -> Integer.parseInt(value.getValue())));
        return inventoryService.isInStock(itemsWithQuantity);
    }
}
