package com.example.springboot311tasksonhandapplicaton.services;


import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot311tasksonhandapplicaton.models.TaskItem;
import com.example.springboot311tasksonhandapplicaton.repositories.TaskItemRepo;

@Service
public class TaskItemService {
    @Autowired
    private TaskItemRepo taskItemRepo;

    public Iterable<TaskItem> getAll(){
        return taskItemRepo.findAll();
    }

    public Optional<TaskItem> getById(Long id){
        return taskItemRepo.findById(id);
    }

    public TaskItem save(TaskItem taskItem){
        if(taskItem.getId()== null){
            taskItem.setWhenCreated(Instant.now());
        }
        taskItem.setLastUpdate(Instant.now());
        return taskItemRepo.save(taskItem);
    }
    
    public void delete(TaskItem taskItem){
        taskItemRepo.delete(taskItem);
    }
}