package com.cranban.springboot.model;

import com.cranban.springboot.domain.TodoItem;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
public class ToDoList {

    private String title;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ToDoList(String title, List<TodoItem> cards) {
        this.title = title;
        this.cards = cards;
    }

    @Column
    @OneToMany(mappedBy = "toDoList",fetch = FetchType.EAGER)

    private List<TodoItem> cards;

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

//    @ElementCollection(targetClass = TodoItem.class)
    public List<TodoItem> getCards() {
        return cards;
    }

    public ToDoList(String title, long id, List<TodoItem> cards) {
        this.title = title;
        this.id = id;
        this.cards = cards;
    }

    public ToDoList(String title, long id) {
        this.title = title;
        this.id = id;
    }
public ToDoList(){

}
    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCards(List<TodoItem> cards) {
        this.cards = cards;
    }
}

