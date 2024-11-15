package com.example.taskmanagementservice.repository;

import com.example.taskmanagementservice.model.Users;

public interface UserRepository {
    Users createUser(Users user);
    
}