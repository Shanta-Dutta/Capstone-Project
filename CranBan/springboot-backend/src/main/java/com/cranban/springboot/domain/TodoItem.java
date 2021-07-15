package com.cranban.springboot.domain;

import lombok.Data;

@Data
public class TodoItem {

    private Integer id;
    private String task;
    private Boolean isDone;


    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", isDOne=" + isDone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (id != null ? !id.equals(todoItem.id) : todoItem.id != null) return false;
        if (task != null ? !task.equals(todoItem.task) : todoItem.task != null) return false;
        return isDone != null ? isDone.equals(todoItem.isDone) : todoItem.isDone == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (isDone != null ? isDone.hashCode() : 0);
        return result;
    }
}
