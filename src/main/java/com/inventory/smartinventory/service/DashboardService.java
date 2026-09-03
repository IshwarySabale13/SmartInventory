package com.inventory.smartinventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.smartinventory.repository.ProductRepository;
import com.inventory.smartinventory.repository.PurchaseRepository;
import com.inventory.smartinventory.repository.SaleRepository;
import com.inventory.smartinventory.repository.SupplierRepository;

@Service
public class DashboardService 
{
	@Autowired
	private ProductRepository productRepository;
	
	public Long getTotalProducts()
	{
		return productRepository.count();
	}
	
	@Autowired
	private SupplierRepository supplierRepository;

	public long getTotalSuppliers()
	{
	    return supplierRepository.count();
	}
	
	@Autowired
	private PurchaseRepository purchaseRepository;

	public long getTotalPurchases()
	{
	    return purchaseRepository.count();
	}
	
	@Autowired
	private SaleRepository saleRepository;

	public long getTotalSales()
	{
	    return saleRepository.count();
	}
	
	public Long getLowStockCount()
	{
		return productRepository.findAll().stream().filter(product -> product.getQuantity() <= 5).count(); 
	}
	
	public double getTotalInventoryValue()
	{
		return productRepository.findAll().stream().mapToDouble(product -> product.getPrice() * product.getQuantity()).sum(); 
	}
}
