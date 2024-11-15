package com.example.taskmanagementservice.model;

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
    
    @Column(name="taskname" ,nullable = false)
    private String taskname;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
}
