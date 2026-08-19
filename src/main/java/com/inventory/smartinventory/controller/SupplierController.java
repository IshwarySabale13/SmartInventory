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

import com.inventory.smartinventory.model.Supplier;
import com.inventory.smartinventory.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController 
{
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping
	public Supplier saveSupplier(@RequestBody Supplier supplier)
	{
		return supplierService.saveSupplier(supplier);
	}
	
	@GetMapping
	public List<Supplier> getAllSuppliers()
	{
		return supplierService.getAllSuppliers();
	}
	
	@GetMapping("/{id}")
	public Supplier getSupplierById(@PathVariable Long id)
	{
		return supplierService.getSupplierById(id);
	}
	
	@PutMapping("/{id}")
	public Supplier updateSupplier(@PathVariable Long id , @RequestBody Supplier supplier)
	{
		return supplierService.updateSupplier(id , supplier);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSupplier(@PathVariable Long id)
	{
		supplierService.deleteSupplier(id);
	}

}
