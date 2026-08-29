package com.inventory.smartinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.smartinventory.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>
{

}
