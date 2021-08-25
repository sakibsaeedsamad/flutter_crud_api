package com.example.flutter_crud_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flutter_crud_api.model.User;
import com.example.flutter_crud_api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers( ) {
        return repository.findAll();
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "user removed" + id;
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());
        return repository.save(existingUser);
    }

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public User getByName(String name) {
        return repository.findByName(name);
    }

}
