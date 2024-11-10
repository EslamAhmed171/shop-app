package org.example.inventoryservice.service;

import org.example.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public boolean isInStock(String code) {
        return inventoryRepository.findByCode(code).isPresent();
    }

    @Transactional(readOnly = true)
    public boolean isInStock(Map<String, Integer> items){
        boolean result = true;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            result &= inventoryRepository.
                    findByCode(entry.getKey(), entry.getValue())
                    .isPresent();
        }
        return  result;
    }
}
