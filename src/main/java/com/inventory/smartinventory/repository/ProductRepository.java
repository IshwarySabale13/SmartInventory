package com.inventory.smartinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.smartinventory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
