package com.example.instant_api.service;

import com.example.instant_api.entity.User;
import com.example.instant_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return this.userRepository.findByName(name).orElse(null);
    }

    public User createUser(String name) {
        User user = new User(name);
        return this.userRepository.save(user);
    }

    public User updateUser(User User) {
        return this.userRepository.save(User);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
