package com.example.taskmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
