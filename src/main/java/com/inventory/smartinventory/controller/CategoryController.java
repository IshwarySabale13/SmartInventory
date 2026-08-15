package com.inventory.smartinventory.controller;

import java.util.List;

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
	
	@GetMapping
	public List<Category> getAllCategories()
	{
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/{id}")	
	public Category getCategoryById(@PathVariable Long id)
	{
		return categoryService.getCategoryById(id);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Long id , @RequestBody Category category)
	{
		return categoryService.updateCategory(id , category);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id)
	{
	    categoryService.deleteCategory(id);
	}
}
