package com.inventory.smartinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.smartinventory.model.Sale;
import com.inventory.smartinventory.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController 
{
	@Autowired
	private SaleService saleService;
	
	@PostMapping
	public Sale saveSale(@RequestBody Sale sale) 
	{
		return saleService.saveSale(sale);
	}
	
	@GetMapping
	public List<Sale> getAllSales()
	{
		return saleService.getAllSales();
	}
	
	@GetMapping("/{id}")
	public Sale getSaleById(@PathVariable Long id)
	{
		return saleService.getSaleById(id);
	}
	
	@PutMapping("/{id}")
	public Sale updateSale(@PathVariable Long id , @RequestBody Sale sale)
	{
		return saleService.updateSale(id, sale);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSale(@PathVariable Long id)
	{
		saleService.deleteSale(id);
	}
}
