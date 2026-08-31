package com.inventory.smartinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.smartinventory.model.Product;
import com.inventory.smartinventory.model.Sale;
import com.inventory.smartinventory.repository.ProductRepository;
import com.inventory.smartinventory.repository.SaleRepository;

@Service
public class SaleService 
{
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Sale saveSale(Sale sale)
	{
		Product product = productRepository.findById(sale.getProduct().getId()).orElse(null);
		
		if(product == null)
		{
			return null;
		}
		
		if(sale.getQuantity() > product.getQuantity())
		{
			return null;
		}
		
		product.setQuantity(product.getQuantity() - sale.getQuantity());
		
		productRepository.save(product);
		
		sale.setProduct(product);
		
		return saleRepository.save(sale);
	}
	
	public List<Sale> getAllSales()
	{
		return saleRepository.findAll();
	}
	
	public Sale getSaleById(Long id)
	{
		Sale existingSale = saleRepository.findById(id).orElse(null);
		
		if(existingSale == null)
		{
			return null;
		}
		
		return existingSale;
	}
	
	public Sale updateSale(Long id , Sale sale)
	{
		Sale existingSale = saleRepository.findById(id).orElse(null);
		
		if(existingSale == null)
		{
			return null;
		}
		
		Product product = productRepository.findById(sale.getProduct().getId()).orElse(null);
		
		if(product == null)
		{
			return null;
		}
		
		Integer quantityDifference = sale.getQuantity() - existingSale.getQuantity();
		
		if(quantityDifference > product.getQuantity())
		{
			return null;
		}
		
		product.setQuantity(product.getQuantity() - quantityDifference);
		
		productRepository.save(product);
		
		existingSale.setQuantity(sale.getQuantity());
		existingSale.setSalePrice(sale.getSalePrice());
		existingSale.setProduct(product);
		
		return saleRepository.save(existingSale); 
	}
	
	public void deleteSale(Long id)
	{
		Sale existingSale = saleRepository.findById(id).orElse(null);
		
		if(existingSale == null)
		{
			return ;
		}
		
		Product product = existingSale.getProduct();

	    product.setQuantity(product.getQuantity() + existingSale.getQuantity());

	    productRepository.save(product);

	    saleRepository.deleteById(id);
	}

}
