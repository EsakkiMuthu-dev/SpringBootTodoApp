package com.firstwebapp.SpringTodo.controller;

import com.firstwebapp.SpringTodo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoContoller {

    private TodoService todoService;

    public TodoContoller(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listTodos(ModelMap modelMap)
    {
        modelMap.put("todos",todoService.getTodosByUserName("Esakki Muthu"));
        return "ListOfTodos";
    }
}
