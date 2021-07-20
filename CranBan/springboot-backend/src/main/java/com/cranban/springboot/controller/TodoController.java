package com.cranban.springboot.controller;

import java.util.List;

import com.cranban.springboot.domain.TodoItem;
import com.cranban.springboot.model.ToDoList;
import com.cranban.springboot.service.TodoService;
import com.cranban.springboot.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
    @Autowired
    private TodolistService todolistService;
     //How does CRUD work?
    // Create = POST = 'http://localhost:8080/api/domainObjejectName'
     //Read = GET  = 'http://localhost:8080/api/domainObjejectName' or 'http://localhost:8080/api/domainObjejectName/{id}'
     //Delete = DELETE = 'http://localhost:8080/api/domainObjejectName/{id}'
     //    fetch all todo items (from database)



     @GetMapping("/api/todoItems")
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
     @GetMapping("/api/todoItems/principal")
public ResponseEntity<?> getPrincipal( @AuthenticationPrincipal OAuth2User principal ){
         return ResponseEntity.ok(principal);
}
    @GetMapping("/api/lists")
     public ResponseEntity<?> getLists(){
//        List<ToDoList> myList = List.of(new ToDoList("Starter",1,List.of(new TodoItem(1,"add something",1),
//                (new TodoItem(2,"add something",2)))));
        Iterable<ToDoList> myLists = todolistService.getLists();
         return ResponseEntity.ok(myLists);

    }

    @PostMapping("api/lists/post")
     public ToDoList postList(@RequestBody ToDoList toDoList){
return todolistService.postToDoList(toDoList);
    }

    @PostMapping("api/lists/post/all")
     public List<ToDoList> postAllLists(@RequestBody List<ToDoList> allLists ){
         return (List<ToDoList>) todolistService.postAllLists(allLists);
    }

 }
