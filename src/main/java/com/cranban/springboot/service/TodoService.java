package com.cranban.springboot.service;
import com.cranban.springboot.domain.TodoItem;
import com.cranban.springboot.repository.TodoRepository;
import com.cranban.springboot.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    @Autowired
    TodolistRepository todolistRepository;

    public List<TodoItem> fetchAllToDoItems() {
        return (List<TodoItem>) todoRepo.findAll();

    }

    public TodoItem updateTodoItem(Long id, TodoItem todoItem) {
      Optional<TodoItem> todoOpt = StreamSupport.stream(todoRepo.findAll().spliterator(), false)
                                    .filter(item -> item.getTimeId().equals(id))
                                    .findAny();

      if (todoOpt.isPresent()){

          TodoItem item = todoOpt.get();
          item.setIsDone(todoItem.getIsDone());
          item.setTaskText(todoItem.getTaskText());
          todoRepo.save(item);
          return item;
      }

        return null;
    }

    public TodoItem createTodoItem(TodoItem todoItem) {
//        TodoItem todoItem = new TodoItem(1L,"add something",1);
        todoItem.setIsDone(false);
        Long id = Long.valueOf(todoItem.getListNumber());
        todoItem.setToDoList(todolistRepository.findById(id).orElseThrow());
//        todoItem = todoRepo.save(todoItem);
//        todoItem.setTaskText("Task #" + todoItem.getTimeId());
        System.out.println(todoItem);
        return todoRepo.save(todoItem);

    }

    public void deleteTodoItem(Long id) {

        todoRepo.deleteById(id);
    }
}

