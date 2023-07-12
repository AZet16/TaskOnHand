package com.example.springboot311tasksonhandapplicaton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot311tasksonhandapplicaton.repositories.TaskItemRepo;
import com.example.springboot311tasksonhandapplicaton.services.TaskItemService;

@Controller
public class TaskFormController {
    @Autowired
    private TaskItemService taskItemService;

    @GetMapping("/add-task")
    public String createForm(){
        return "generating-new-task";
    }
}
