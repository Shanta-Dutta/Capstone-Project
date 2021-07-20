package com.cranban.springboot.service;

import com.cranban.springboot.model.ToDoList;
import com.cranban.springboot.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodolistService {
    @Autowired
    public TodolistRepository todolistRepository;

    public Iterable<ToDoList> postAllLists(List<ToDoList> allLists) {
        return todolistRepository.saveAll(allLists);
    }

    public Iterable<ToDoList> getLists(){
        return todolistRepository.findAll();
    }

public ToDoList postToDoList(ToDoList toDoList){
        return todolistRepository.save(toDoList);
}

}
