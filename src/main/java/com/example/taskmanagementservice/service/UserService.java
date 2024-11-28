package com.example.taskmanagementservice.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.taskmanagementservice.model.*;
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

    @Override
    public Users getUserById(long userId) {
        try{
            Users user=userJpaRepository.findById(userId).get();
            return user;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<Users> getAllUsers() {
        List<Users> allUsers=userJpaRepository.findAll();
        ArrayList<Users> users=new ArrayList<>(allUsers);
        return users;
    }
    
}
