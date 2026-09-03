package com.inventory.smartinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.smartinventory.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController 
{
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/products")
	public Long getTotalProducts()
	{
		return dashboardService.getTotalProducts();
	}
	
	@GetMapping("/suppliers")
	public long getTotalSuppliers()
	{
	    return dashboardService.getTotalSuppliers();
	}
	
	@GetMapping("/purchases")
	public long getTotalPurchases()
	{
	    return dashboardService.getTotalPurchases();
	}
	
	@GetMapping("/sales")
	public long getTotalSales()
	{
	    return dashboardService.getTotalSales();
	}
	
	@GetMapping("/low-stock")
	public Long getLowStockCount()
	{
		return dashboardService.getLowStockCount();
	}
	
	@GetMapping("/inventory-value")
	public double getTotalInventoryValue()
	{
		return dashboardService.getTotalInventoryValue();
	}

}
