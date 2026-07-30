package com.inventory.smartinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inventory.smartinventory.model.Category;
import com.inventory.smartinventory.service.CategoryService;

@RestController
@RequestMapping("/categories")

public class CategoryController 
{
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public Category saveCategory(@RequestBody Category category)
	{
		 return categoryService.saveCategory(category);
	}
	
}
