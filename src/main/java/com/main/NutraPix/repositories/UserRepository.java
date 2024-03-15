package com.main.NutraPix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.NutraPix.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
