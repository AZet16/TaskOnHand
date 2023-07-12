package com.example.springboot311tasksonhandapplicaton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springboot311tasksonhandapplicaton.services.TaskItemService;

@Controller
public class HomeController {
    @Autowired
    private TaskItemService taskItemService;

    @GetMapping("/") //root controller handler
    public ModelAndView index(){
        //ModelAndView is a spring modek UI object
        ModelAndView modelAndView = new ModelAndView("index"); //index is a view name is the name of html file
        modelAndView.addObject("taskItem",taskItemService.getAll()); //taskItem in attribute name
        return modelAndView;
    }
}
