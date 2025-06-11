package com.firstwebapp.SpringTodo.pojo;

import java.time.LocalDate;

public class Todo {
    private String name;
    private String author;
    private LocalDate targetDate;
    private  boolean isCompleted;

    public Todo(String name,String author, LocalDate targetDate)
    {
        this.name = name;
        this.author = author;
        this.targetDate = targetDate;
        this.isCompleted = false;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
                ", author='" + author + '\'' +
                ", targetDate=" + targetDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
