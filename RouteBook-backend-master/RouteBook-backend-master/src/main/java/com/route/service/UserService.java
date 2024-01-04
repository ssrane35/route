package com.route.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route.entities.User;
import com.route.repository.UserRepository;

@Service
public class UserService {
	  @Autowired
	private  UserRepository userRepository;

  
    

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User createUser(User user) {
        // Add any validation or business logic before saving the user
        return userRepository.save(user);
    }
    
    public User updateUser(int id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null; // User not found
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


}
