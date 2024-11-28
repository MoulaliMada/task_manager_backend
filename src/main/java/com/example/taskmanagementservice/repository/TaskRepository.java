package com.example.taskmanagementservice.repository;

import java.util.*;

import com.example.taskmanagementservice.model.Tasks;

public interface TaskRepository {

    public Tasks saveTask(long taskId,Tasks tasks);
    public List<Tasks> getAllTasksByUserId(long userId);
    public Tasks getTaskById(long userId,long taskId);
    public void deleteTaskById(long userId,long taskId);
    
}