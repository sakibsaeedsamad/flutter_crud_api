package com.example.flutter_crud_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flutter_crud_api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}
