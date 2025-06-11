package com.firstwebapp.SpringTodo.service;

import com.firstwebapp.SpringTodo.pojo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todoList ;
    
    static
    {
        todoList = new ArrayList<>();
        todoList.add(new Todo("Learn Spring Boot","Esakki Muthu", LocalDate.now().plusDays(3)));
        todoList.add(new Todo("Start Learning Rust or Anything that makes you happier","Esakki Muthu",LocalDate.now().plusDays(8)));
    }


    public  List<Todo> getTodosByUserName(String userName)
    {
        return todoList;
    }
}
