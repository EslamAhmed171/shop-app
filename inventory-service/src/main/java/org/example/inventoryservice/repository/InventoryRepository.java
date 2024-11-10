package org.example.inventoryservice.repository;

import org.example.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByCode(String code);

    @Query(
        """
        SELECT i FROM Inventory i
        WHERE i.code = :code
        AND i.quantity >= :quantity
        """
    )
    Optional<Inventory> findByCode(String code, Integer quantity);
}
