package com.example.springboot311tasksonhandapplicaton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot311tasksonhandapplicaton.models.TaskItem;
import com.example.springboot311tasksonhandapplicaton.services.TaskItemService;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;

import jakarta.validation.Valid;

@Controller
public class TaskFormController {
    @Autowired
    private TaskItemService taskItemService;

    @GetMapping("/add-task")
    public String createForm(TaskItem taskItem) { //this name is used in following html
        return "generating-new-task";
    }
    
     @PostMapping("/newtask") 
     public String createNewTask(@Valid TaskItem taskItem, BindingResult result, Model model) {
         TaskItem task = new TaskItem();
         task.setDescription(taskItem.getDescription());
         //task.setCategory(taskItem.getCategory());
         //task.setCurrentState(taskItem.getCurrentState());
         task.setIsDone(taskItem.getIsDone());

         taskItemService.save(taskItem);
         return "redirect:/";

     }
    
     @GetMapping("/delete/{id}")
     public String deleteTask( @PathVariable("id") Long id, Model model){
         TaskItem task = taskItemService.getById(id)
        .orElseThrow(() -> new IllegalArgumentException("Task with id "+ id+ "does not exist"));
    
       taskItemService.delete(task);
       return "redirect:/";
    }

     @GetMapping("/edit/{id}")
     public String editTask(@PathVariable("id") Long id, Model model) {
         TaskItem task = taskItemService.getById(id)
                 .orElseThrow(() -> new IllegalArgumentException("Task with id " + id + "does not exist"));

         model.addAttribute("task", task);
         return "edit-task";
     }
    
     @PostMapping("/update/{id}")
     public String updateTask(@PathVariable("id") Long id,
      @Valid TaskItem taskItem, BindingResult result, Model model) {
        TaskItem task = taskItemService.getById(id)
        .orElseThrow(() -> new IllegalArgumentException("Task with id " + id + "does not exist"));
        task.setDescription(taskItem.getDescription());
        //task.setCategory(taskItem.getCategory());
        //task.setCurrentState(taskItem.getCurrentState());
        task.setIsDone(taskItem.getIsDone());


        taskItemService.save(task);

        return "redirect:/";
     }

}
