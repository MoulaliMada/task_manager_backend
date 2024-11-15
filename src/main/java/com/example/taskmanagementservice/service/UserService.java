package com.example.taskmanagementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanagementservice.model.Users;
import com.example.taskmanagementservice.repository.UserJpaRepository;
import com.example.taskmanagementservice.repository.UserRepository;

@Service
public class UserService implements UserRepository{

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public Users createUser(Users user) {
        userJpaRepository.save(user);
        return user;
    }
    
}
