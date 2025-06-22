package com.firstwebapp.SpringTodo.pojo;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String name;
    private LocalDate targetDate;
    private  boolean isCompleted;

    private static int idCount =0;

    public Todo(String name,LocalDate targetDate,boolean isCompleted)
    {
        this.id = ++idCount;
        this.name = name;
        this.targetDate = targetDate;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "name='" + name + '\'' +
                ", targetDate=" + targetDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
