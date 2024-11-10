package org.example.inventoryservice;

import org.example.inventoryservice.model.Inventory;
import org.example.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(InventoryRepository inventoryRepository) {
        return args -> {
            inventoryRepository.save(new Inventory(1L, "product-1", 100));
            inventoryRepository.save(new Inventory(2L, "product-2", 100));
        };
    }

}
