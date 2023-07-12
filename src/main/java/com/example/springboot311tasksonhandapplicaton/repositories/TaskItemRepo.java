package com.example.springboot311tasksonhandapplicaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot311tasksonhandapplicaton.models.TaskItem;

@Repository
public interface TaskItemRepo extends JpaRepository<TaskItem,Long>{
    
}
