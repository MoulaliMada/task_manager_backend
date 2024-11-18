package com.example.taskmanagementservice.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.taskmanagementservice.model.Users;
import com.example.taskmanagementservice.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users createUser(@RequestBody Users user){
        return userService.createUser(user);
    }

    @GetMapping("/{userId}/user")
    public Users getUserById(@PathVariable(name = "userId") long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/users")
    public ArrayList<Users> getAllUsers(){
        return userService.getAllUsers();
    }
}
