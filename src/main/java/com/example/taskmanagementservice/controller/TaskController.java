package com.example.taskmanagementservice.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanagementservice.model.Tasks;
import com.example.taskmanagementservice.service.TaskService;
@RestController
public class TaskController {

    @Autowired
    public TaskService taskService;

    @PostMapping("/{userId}/tasks")
    public Tasks saveTask(@PathVariable(name="userId") Long userId ,@RequestBody Tasks tasks){
        return taskService.saveTask(userId,tasks);
    }

    @GetMapping("/{userId}/alltasks")
    public List<Tasks> getAllTasksByUserId(@PathVariable(name="userId") long userId){
        return taskService.getAllTasksByUserId(userId);
    }

    @GetMapping("/{taskId}/tasks")
    public Tasks getTaskById(@PathVariable(name="taskId") long taskId){
        return taskService.getTaskById(taskId);
    }
}
