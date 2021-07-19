package com.cranban.springboot.service;
import com.cranban.springboot.domain.TodoItem;
import com.cranban.springboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;
    public List<TodoItem> fetchAllToDoItems() {
        return todoRepo.fetchAllTodoItems();

    }

    public TodoItem updateTodoItem(Integer id, TodoItem todoItem) {
      Optional<TodoItem> todoOpt =  todoRepo.fetchAllTodoItems()
                                    .stream()
                                    .filter(item -> item.getTimeId().equals(id))
                                    .findAny();

      if (todoOpt.isPresent()){

          TodoItem item = todoOpt.get();
          item.setIsDone(todoItem.getIsDone());
          item.setTaskText(todoItem.getTaskText());
          return item;
      }

        return null;
    }

    public TodoItem createTodoItem() {
        TodoItem todoItem = new TodoItem(1,"add something",1);
        todoItem.setIsDone(false);
        todoItem = todoRepo.save(todoItem);
        todoItem.setTaskText("Task #" + todoItem.getTimeId());
        return todoItem;
    }

    public void deleteTodoItem(Integer id) {
        todoRepo.delete(id);
    }
}

