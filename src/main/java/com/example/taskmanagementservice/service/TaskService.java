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
    public Tasks saveTask(long taskId, Tasks tasks) {
        try{
            Users user=userJpaRepository.findById(taskId).get();
            tasks.setUsers(user);
            return taskJpaRepository.save(tasks);
        } catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong userId");
        }
    }

    @Override
    public List<Tasks> getAllTasksByUserId(long userId) {
        List<Long> idList = new ArrayList<>();
        idList.add(userId); 
        List<Tasks> tasks = taskJpaRepository.findAllByUserId(idList);
        return tasks;
    }

    @Override
    public Tasks getTaskById(long taskId) {
        try{
            Tasks task=taskJpaRepository.findById(taskId).get();
            return task;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    
    
}
