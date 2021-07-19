package com.cranban.springboot.model;

import com.cranban.springboot.domain.TodoItem;

import java.util.List;

public class ToDoList {

    private String title;
    private long id;
    private List<TodoItem> cards;

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public List<TodoItem> getCards() {
        return cards;
    }

    public ToDoList(String title, long id, List<TodoItem> cards) {
        this.title = title;
        this.id = id;
        this.cards = cards;
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

