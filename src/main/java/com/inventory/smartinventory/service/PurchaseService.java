package com.inventory.smartinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.smartinventory.model.Purchase;
import com.inventory.smartinventory.repository.PurchaseRepository;

import com.inventory.smartinventory.model.Product;
import com.inventory.smartinventory.model.Supplier;
import com.inventory.smartinventory.repository.ProductRepository;
import com.inventory.smartinventory.repository.SupplierRepository;

@Service
public class PurchaseService 
{
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SupplierRepository supplierRepository;

	public Purchase savePurchase(Purchase purchase)
	{
		Product product = productRepository.findById(purchase.getProduct().getId()).orElse(null);
		
		Supplier supplier = supplierRepository.findById(purchase.getSupplier().getId()).orElse(null);
		
		if(product == null || supplier == null)
		{
			return null;
		}
		
		product.setQuantity(product.getQuantity() + purchase.getQuantity());
		
		productRepository.save(product);
		
		purchase.setProduct(product);
		purchase.setSupplier(supplier);
				
		return purchaseRepository.save(purchase);
	}
	
	public List<Purchase> getAllPurchase()
	{
		return purchaseRepository.findAll();
	}
	
	public Purchase getPurchaseById(Long id)
	{
		Purchase existingPurchase = purchaseRepository.findById(id).orElse(null);
		
		if(existingPurchase == null)
		{
			return null;
		}
		
		return existingPurchase;
	}
	
	public Purchase updatePurchase(Long id , Purchase purchase)
	{
		Purchase existingPurchase = purchaseRepository.findById(id).orElse(null);
		
		if(existingPurchase == null)
		{
			return null;
		}
		
		Product product = productRepository.findById(purchase.getProduct().getId()).orElse(null);
		
		Supplier supplier = supplierRepository.findById(purchase.getSupplier().getId()).orElse(null);
		
		if(product == null || supplier == null)
		{
			return null;
		}
		
		Integer quantityDifference = purchase.getQuantity() - existingPurchase.getQuantity();
		
		product.setQuantity(product.getQuantity() + quantityDifference);
		
		productRepository.save(product);
		
		existingPurchase.setQuantity(purchase.getQuantity());
		existingPurchase.setPurchasePrice(purchase.getPurchasePrice());
		existingPurchase.setProduct(product);
		existingPurchase.setSupplier(supplier);
		
		return purchaseRepository.save(existingPurchase); 
		
	}
	
	public void deletePurchase(long id)
	{
		Purchase existingPurchase = purchaseRepository.findById(id).orElse(null);
		
		if(existingPurchase == null)
		{
			return ;
		}
		
		Product product = existingPurchase.getProduct();
		
		product.setQuantity(product.getQuantity() - existingPurchase.getQuantity());
		
		productRepository.save(product);
		
		purchaseRepository.deleteById(id);
		
	}
	
	
}
