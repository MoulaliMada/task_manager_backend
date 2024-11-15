package com.example.taskmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskmanagementservice.model.Users;
@Repository
public interface UserJpaRepository extends JpaRepository<Users ,Long> {

    
}