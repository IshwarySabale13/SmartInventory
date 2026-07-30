package com.inventory.smartinventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.smartinventory.model.Category;
import com.inventory.smartinventory.repository.CategoryRepository;

@Service
public class CategoryService 
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category saveCategory(Category category)
	{
		return categoryRepository.save(category);
	}
     
}
