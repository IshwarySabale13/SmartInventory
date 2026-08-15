package com.inventory.smartinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

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
	
	public List<Category> getAllCategories()
	{
		return categoryRepository.findAll();
	}
	
	public Category getCategoryById(Long id)
	{
		return categoryRepository.findById(id).orElse(null);
	}
	
	public Category updateCategory(Long id , Category category)
	{
		Category existingCategory = categoryRepository.findById(id).orElse(null);
		
		if(existingCategory == null)
		{
			return null;
		}	
		
		existingCategory.setName(category.getName());
		existingCategory.setDescription(category.getDescription());
		
		return categoryRepository.save(existingCategory);
	}
	
    public void deleteCategory(Long id) {

        Category existingCategory = categoryRepository.findById(id).orElse(null);

        if (existingCategory == null) 
        {
            return;
        }

        categoryRepository.deleteById(id);
    }
    
}
