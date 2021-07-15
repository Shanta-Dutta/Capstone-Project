package com.cranban.springboot.controller;

import java.util.List;

import com.cranban.springboot.domain.TodoItem;
import com.cranban.springboot.model.User;
import com.cranban.springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


 @CrossOrigin(origins = "http://localhost:3000")
//http://localhost:8080
    @RestController
//    @RequestMapping("api")
    public class TodoController {

     //// front end sends "HTTPRequest"  to java server that hits"controller" like below
     //HttpRequest ---> controller ---> execute code that is in service -->Repository
     //front end <-- controller <-- Service <-- Repository
     @Autowired
     private TodoService todoService;

     //How does CRUD work?
    // Create = POST = 'http://localhost:8080/api/domainObjejectName'
     //Read = GET  = 'http://localhost:8080/api/domainObjejectName' or 'http://localhost:8080/api/domainObjejectName/{id}'
     //Delete = DELETE = 'http://localhost:8080/api/domainObjejectName/{id}'
     //    fetch all todo items (from database)



     @GetMapping("api/todoItems")
     public ResponseEntity<?> fetchAllToDoItems() {
         List<TodoItem> todoItems = todoService.fetchAllToDoItems();
         return ResponseEntity.ok(todoItems);
     }

     @PostMapping("/api/todoItems")
     public ResponseEntity<?>createNewTodoItem(){
       TodoItem todoItem =  todoService.createTodoItem();
        return ResponseEntity.ok(todoItem);

     }

     @PutMapping("/api/todoItems/{id}")
     public ResponseEntity<?> updateToDoItems(@PathVariable Integer id, @RequestBody TodoItem todoItem) {
        // Here "todoItem" is basically the  JSON "body" that is passed here // Call the service
         //get the data back from server
        TodoItem updatedTodoItem = todoService.updateTodoItem(id, todoItem);

         //send it back to front-end
        return ResponseEntity.ok(updatedTodoItem);

     }

     @DeleteMapping("/api/todoItems/{id}")
     public ResponseEntity<?> deleteTodoItem(@PathVariable Integer id){
          todoService.deleteTodoItem(id);
         return ResponseEntity.ok("ok");

     }
 }
