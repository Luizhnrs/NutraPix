package com.main.NutraPix.dtos;

import com.main.NutraPix.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull(message = "The name cannot be null")
        @NotBlank(message = "This field cannot be empty")
        @Size(min = 4, message = "the name must contain at least 4 characters", max = 64)
        String name,
        @NotNull(message = "The email cannot be null")
        @NotBlank(message = "This field cannot be empty") 
        @Email
        String email,
        @NotNull(message = "The password cannot be null")
        @NotBlank(message = "This field cannot be empty")
        @Size(min = 8, message = "the password must contain at least 8 characters")
        String password) {
    
    
     public User toModel() {
        return new User(name, email, password);
    }
}
 