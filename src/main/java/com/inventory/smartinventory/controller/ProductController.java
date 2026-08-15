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

import com.inventory.smartinventory.model.Product;
import com.inventory.smartinventory.service.ProductService;

@RestController
@RequestMapping("/products") 
public class ProductController 
{
	   @Autowired
	    private ProductService productService;
   
	   @PostMapping	
	   public Product saveProduct(@RequestBody Product product)
	   {
		   return productService.saveProduct(product);
	   }
	   
	   @GetMapping
	   	public List<Product> getAllProducts()
	   	{
		   return productService.getAllProducts();		   
	   	}
	   
	   @GetMapping("/{id}")
	   public Product getProductById(@PathVariable Long id)
	   {
		   Product product = productService.getProductById(id);
		   
		   if(product == null)
		   {
			   return null;
		   }
		   
		   return product;
	   }
	   
	   @PutMapping("/{id}")
	   public Product updateProduct(@PathVariable Long id , @RequestBody Product product)
	   {
		   return productService.updateProduct(id, product);
	   }
	   
	   @DeleteMapping("/{id}")
	   public void deleteProduct(@PathVariable Long id)
	   {
		   productService.deleteProduct(id);
	   }
}	   
