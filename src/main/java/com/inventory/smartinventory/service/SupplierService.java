package com.inventory.smartinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.inventory.smartinventory.model.Supplier;
import com.inventory.smartinventory.repository.SupplierRepository;

@Service
public class SupplierService 
{
	@Autowired
	private SupplierRepository supplierRepository;
	
	public Supplier saveSupplier(Supplier supplier)
	{
		return supplierRepository.save(supplier);
	}
	
	public List<Supplier> getAllSuppliers()
	{
		return supplierRepository.findAll();
	}
	
	public Supplier getSupplierById(Long id)
	{
		Supplier existingSupplier = supplierRepository.findById(id).orElse(null);
		
		if(existingSupplier == null)
		{
			return null;
		}
		
		return existingSupplier;
	}
	
	public Supplier updateSupplier(Long id ,Supplier supplier)
	{
	    Supplier existingSupplier  = supplierRepository.findById(id).orElse(null);
	    
	    if(existingSupplier == null)
	    {
	    	return null;
	    }
	    
	    existingSupplier.setName(supplier.getName());
	    existingSupplier.setEmail(supplier.getEmail());
	    existingSupplier.setPhone(supplier.getPhone());
	    existingSupplier.setAddress(supplier.getAddress());
	    
	    return supplierRepository.save(existingSupplier);
	}
	
	public void deleteSupplier(Long id)
	{
		Supplier existingSupplier = supplierRepository.findById(id).orElse(null);
		
		if(existingSupplier == null)
		{
			return;
		}
		
		supplierRepository.deleteById(id);
	}

}
