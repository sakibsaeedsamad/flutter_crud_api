package com.example.flutter_crud_api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.flutter_crud_api.model.User;
import com.example.flutter_crud_api.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {

        return service.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

}
