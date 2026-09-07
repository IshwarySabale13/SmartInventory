package com.inventory.smartinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.smartinventory.model.User;

public interface UserRepository extends JpaRepository<User , Long>
{
	User findByUsername(String username);
}
