package com.cranban.springboot.repository;

import com.cranban.springboot.model.ToDoList;
import org.springframework.data.repository.CrudRepository;

public interface TodolistRepository extends CrudRepository <ToDoList, Long> {

}
