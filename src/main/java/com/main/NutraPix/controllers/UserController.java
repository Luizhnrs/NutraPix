package com.main.NutraPix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.NutraPix.dtos.UserRequest;
import com.main.NutraPix.entities.User;
import com.main.NutraPix.services.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRequest userRequest){
       User user = userRequest.toModel();
       User userSaved = userService.registerUser(user);
       return ResponseEntity.ok().body(userSaved);
    }
}
