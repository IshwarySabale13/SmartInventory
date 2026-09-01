package com.inventory.smartinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.smartinventory.model.Product;
import com.inventory.smartinventory.repository.ProductRepository;

@Service
public class InventoryService 
{
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getInventory()
	{
		return productRepository.findAll();
	}
	
	public List<Product> getLowStockProducts()
	{
	    List<Product> products = productRepository.findAll();

	    return products.stream().filter(product -> product.getQuantity() <= 5).toList();
	}
}
