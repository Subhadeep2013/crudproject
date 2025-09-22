package com.example.crudproject.service.impl;

import com.example.crudproject.model.User;
import com.example.crudproject.repository.UserRepository;
import com.example.crudproject.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Constructor injection (preferred)
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        System.out.println("DEBUG: getAllUsers() called");
        return userRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        System.out.println("DEBUG: createUser() called with name=" + user.getName());
        return userRepository.save(user);
    }


    @Override
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(existing -> {
            existing.setName(userDetails.getName());
            existing.setEmail(userDetails.getEmail());
            return userRepository.save(existing);
        });
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
