package com.cranban.springboot.domain;

import com.cranban.springboot.model.ToDoList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Objects;
@Entity
@Data

public class TodoItem {
@Id
    private Long timeId;
    private String taskText;
    private Boolean isDone;
    private Integer listNumber;
    @ManyToOne
    @JsonIgnore
    private ToDoList toDoList;

    public TodoItem(Long i, String task, Integer listnumber) {
        this.timeId = i;
        this.taskText = task;
        this.listNumber = listnumber;
    }
//    private ToDoList toDoList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return Objects.equals(timeId, todoItem.timeId) && Objects.equals(taskText, todoItem.taskText) && Objects.equals(isDone, todoItem.isDone) && Objects.equals(listNumber, todoItem.listNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeId, taskText, isDone, listNumber);
    }

    public TodoItem(){

    }
    @Override
    public String toString() {
        return "TodoItem{" +
                "timeId=" + timeId +
                ", taskText='" + taskText + '\'' +
                ", isDone=" + isDone +
                ", listNumber=" + listNumber +
                '}';
    }
}
