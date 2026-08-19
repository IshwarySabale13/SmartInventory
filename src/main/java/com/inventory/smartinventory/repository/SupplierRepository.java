package com.inventory.smartinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.smartinventory.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> 
{

}
