package com.example.taskmanagementservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanagementservice.model.Tasks;

@Repository
public interface TaskJpaRepository extends JpaRepository<Tasks ,Long> {
    List<Tasks> findAllByUsersId(Long userId);
} 
