package com.inventory.smartinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.smartinventory.model.Product;
import com.inventory.smartinventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController 
{
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping
	public List<Product> getInventory()
	{
		return inventoryService.getInventory();
	}
	
	@GetMapping("/low-stock")
	public List<Product> getLowStockProducts()
	{
	    return inventoryService.getLowStockProducts();
	}
}
