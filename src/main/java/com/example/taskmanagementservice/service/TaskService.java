package com.example.taskmanagementservice.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.taskmanagementservice.model.Tasks;
import com.example.taskmanagementservice.model.Users;
import com.example.taskmanagementservice.repository.TaskJpaRepository;
import com.example.taskmanagementservice.repository.TaskRepository;
import com.example.taskmanagementservice.repository.UserJpaRepository;

@Service
public class TaskService implements TaskRepository{
    
    @Autowired
    private TaskJpaRepository taskJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public Tasks saveTask(long userId, Tasks tasks) {
        try{
            Users user=userJpaRepository.findById(userId).get();
            tasks.setUsers(user);
            return taskJpaRepository.save(tasks);
        } catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong userId");
        }
    }

    @Override
    public List<Tasks> getAllTasksByUserId(long userId) {
        userJpaRepository.findById(userId).orElseThrow(
        ()-> new ResponseStatusException(HttpStatus.NOT_FOUND) 
        );
        return taskJpaRepository.findAllByUsersId(userId);
    }

    @Override
    public Tasks getTaskById(long userId, long taskId) {
        Users user= userJpaRepository.findById(userId).orElseThrow(
        ()-> new ResponseStatusException(HttpStatus.NOT_FOUND ,"Wrong user")
        );
        Tasks task=taskJpaRepository.findById(taskId).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND ,"task not found") 
            );
        if(user.getId() != task.getUsers().getId()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"task is not belongs to user"); 
        }    
        return task;
    }

    @Override
    public void deleteTaskById(long userId, long taskId) {
        Users user= userJpaRepository.findById(userId).orElseThrow(
        ()-> new ResponseStatusException(HttpStatus.NOT_FOUND ,"Wrong user")
        );
        Tasks task=taskJpaRepository.findById(taskId).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND ,"task not found") 
            );
        if(user.getId() != task.getUsers().getId()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"task is not belongs to user"); 
        }    
        taskJpaRepository.deleteById(taskId); //delete the task
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    
    
}
