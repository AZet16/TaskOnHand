package com.example.springboot311tasksonhandapplicaton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springboot311tasksonhandapplicaton.models.TaskItem;
import com.example.springboot311tasksonhandapplicaton.repositories.TaskItemRepo;
import com.example.springboot311tasksonhandapplicaton.services.TaskItemService;

@Controller
public class TaskFormController {
    @Autowired
    private TaskItemService taskItemService;

    @GetMapping("/add-task")
    public String createForm(TaskItem taskItem) {
        return "generating-new-task";
    }
    
    @GetMapping("/new-task")
    public String createNewTask(@Valid TaskItem taskItem, BindingResult result, Model model) {
        TaskItem task1 = new TaskItem();
        task1.setDescription(taskItem.getDescription());
        //task1.setCategory(taskItem.getCategory());
        //task1.setCurrentState(taskItem.getCurrentState());
        //task1.setIsDone(taskItem.getIsDone());

        taskItemService.save(task1);
        
        return "redirect:/";

    }
}
