package com.cranban.springboot.domain;

import com.cranban.springboot.model.ToDoList;
import lombok.Data;

import java.util.Objects;

@Data
public class TodoItem {

    private Integer timeId;
    private String taskText;
    private Boolean isDone;
    private Integer listNumber;


    public TodoItem(int i, String task, Integer listnumber) {
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
