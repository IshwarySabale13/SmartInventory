package com.inventory.smartinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.smartinventory.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>
{
	

}
