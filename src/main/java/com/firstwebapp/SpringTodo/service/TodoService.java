package com.firstwebapp.SpringTodo.service;

import com.firstwebapp.SpringTodo.pojo.Todo;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private static List<Todo> todoList ;
    
    static
    {
        todoList = new ArrayList<>();
        todoList.add(new Todo("Learn Spring Boot", LocalDate.now().plusDays(3),false));
        todoList.add(new Todo("Start Learning Rust or Anything that makes you happier",LocalDate.now().plusDays(8),false));
    }


    public  List<Todo> getTodos()
    {
        return todoList;
    }

    public void addTodo(String todo)
    {
       todoList.add(new Todo(todo, LocalDate.now().plusDays(3),false));
    }
    public void addTodo(String todo,LocalDate targetDate)
    {
        todoList.add(new Todo(todo, targetDate,false));
    }

    public void deleteTodoByID(int id)
    {
        todoList.remove(this.findTodoByID(id));
    }

    public Todo findTodoByID(int id)
    {
        Optional<Todo> todo =  todoList.stream().filter(t -> t.getId() == id).findFirst();

        if(todo.isEmpty())
        {
            throw new ResourceAccessException("Resource not Found");
        }
        return todo.get();
    }

    public void updateTodoByID(int id ,String todoName ,LocalDate targetDate,boolean isCompleted)
    {
        Todo todo = this.findTodoByID(id);
        todo.setCompleted(isCompleted);
        todo.setName(todoName);
        todo.setTargetDate(targetDate);
    }

}
