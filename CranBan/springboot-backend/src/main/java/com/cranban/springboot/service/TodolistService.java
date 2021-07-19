package com.cranban.springboot.service;

import com.cranban.springboot.model.ToDoList;
import com.cranban.springboot.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodolistService {
    @Autowired
    public TodolistRepository todolistRepository;

    public Iterable<ToDoList> getLists(){
        return todolistRepository.findAll();
    }



}
