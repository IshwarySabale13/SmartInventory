package com.inventory.smartinventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.smartinventory.model.Product;
import com.inventory.smartinventory.model.Supplier;
import com.inventory.smartinventory.repository.ProductRepository;
import com.inventory.smartinventory.repository.SupplierRepository;

@Service
public class ProductService 
{
	  @Autowired
	    private ProductRepository productRepository;
	  
	  @Autowired
	  private SupplierRepository supplierRepository;

	    public Product saveProduct(Product product)
	    {
	        return productRepository.save(product);
	    }
	    
	    public List<Product> getAllProducts()
	    {
	    	return productRepository.findAll();
	    }
	    	        
	    public Product getProductById(Long id)
	    {
	    	Product existingProduct = productRepository.findById(id).orElse(null);
	    	
	    	if(existingProduct == null) 
	    	{
	    		return null;	    		
	    	}
	    	return existingProduct;
	    }
	    
	    public Product updateProduct(Long id, Product product)
	    {
	        Product existingProduct = productRepository.findById(id).orElse(null);

	        if(existingProduct == null)
	        {
	            return null;
	        }
	        
	        Long supplierId = product.getSuppliers().get(0).getId();	
	        
	        Supplier supplier = supplierRepository.findById(supplierId).orElse(null);
	        
	        if(supplier == null)
	        {
	        	return null;
	        }
	        
	        existingProduct.getSuppliers().add(supplier);
	        
	        existingProduct.setName(product.getName());
	        existingProduct.setPrice(product.getPrice());
	        existingProduct.setQuantity(product.getQuantity());

	        return productRepository.save(existingProduct);
	    }
	    
	    public void deleteProduct(Long id)
	    {
	    	Product existingProduct = productRepository.findById(id).orElse(null);
	    	
	    	if(existingProduct == null)
	    	{
	    		return;
	    	}
	    	productRepository.deleteById(id);
	    }
	    
}
