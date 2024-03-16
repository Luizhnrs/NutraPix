package com.main.NutraPix.dtos;

import com.main.NutraPix.entities.User;

public record UserRequest(String name, String email, String password) {
    public User toModel(){
     return new User (name, email, password);  
    }
}
