package com.cranban.springboot.repository;

import com.cranban.springboot.model.ToDoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodolistRepository extends CrudRepository <ToDoList, Long> {

}
