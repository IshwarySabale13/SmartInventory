package com.inventory.smartinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.smartinventory.model.Category;

public interface CategoryRepository extends JpaRepository<Category , Long>
{

}
