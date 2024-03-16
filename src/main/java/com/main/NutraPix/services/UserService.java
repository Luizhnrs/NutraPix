package com.main.NutraPix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.NutraPix.entities.User;
import com.main.NutraPix.repositories.UserRepository;
import com.main.NutraPix.utils.RandomString;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("This email already exists");
        }else{
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            String randomCode = RandomString.generateRandomString(64);
            user.setVerificationCode(randomCode);
            user.setEnable(false);
            
            User savedUser = userRepository.save(user);
            return savedUser;
        }
    }
}
