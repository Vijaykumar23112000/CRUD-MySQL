package com.magret.service;

import com.magret.model.User;
import com.magret.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    public List<User> getUserByName(String name){
        return userRepository.findByName(name);
    }

    public List<User> getByLocation(String location){
        return userRepository.fetchByLocation(location);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User request) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            return userRepository.save(user);
        }
        else{
           return createUser(request);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
