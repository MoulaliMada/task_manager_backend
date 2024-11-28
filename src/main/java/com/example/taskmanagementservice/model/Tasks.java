package com.example.taskmanagementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
    
    @Column(name="taskname",nullable = false)
    private String taskname;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users users;

}
