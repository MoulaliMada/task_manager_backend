package com.example.taskmanagementservice.repository;

import java.util.*;

import com.example.taskmanagementservice.model.Users;

public interface UserRepository {
    Users createUser(Users user);
    Users getUserById(long userId);
    ArrayList<Users> getAllUsers();
}