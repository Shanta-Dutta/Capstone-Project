package com.cranban.springboot.repository;

import com.cranban.springboot.domain.TodoItem;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class TodoRepository {
    private Integer idCounter = 0;
    private List<TodoItem> todoItems = new ArrayList<>();
    public List<TodoItem> fetchAllTodoItems(){
       if (todoItems.size() == 0) {
           TodoItem item1 = new TodoItem(1,"add something",1);
           item1.setTimeId(idCounter++);
           item1.setIsDone(true);
           item1.setTaskText("Task 1");
           todoItems.add(item1);
        }
        return todoItems;

    }


    public TodoItem save (TodoItem todoItem){
        todoItem.setTimeId((idCounter++));
        todoItems.add(todoItem);
        return todoItem;
    }

    public void delete(Integer id) {
      todoItems = todoItems.stream()
                 .filter(todoItem -> !todoItem.getTimeId().equals(id))
                .collect(Collectors.toList());
    }
}
