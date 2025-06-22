package com.firstwebapp.SpringTodo.controller;

import com.firstwebapp.SpringTodo.pojo.Todo;
import com.firstwebapp.SpringTodo.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class TodoContoller {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private TodoService todoService;

    public TodoContoller(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listTodos(ModelMap modelMap)
    {
        modelMap.put("todos",todoService.getTodos());
        return "ListOfTodos";
    }


    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String showTodoPage()
    {
        return "addTodo";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String addTodoToList(@RequestParam String todo, @RequestParam String targetDate)
    {
        logger.info(targetDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        todoService.addTodo(todo,LocalDate.parse(targetDate, formatter));
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo",method = RequestMethod.DELETE)
    public void deleteTodo(@RequestParam int id)
    {
        todoService.deleteTodoByID(id);
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id,ModelMap modelMap)
    {
        Todo todo = todoService.findTodoByID(id);
        modelMap.put("todo",todo);
        return "updateTodo";
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.PUT)
    public String updateTodo(@RequestParam int id,@RequestParam String todo,@RequestParam LocalDate targetDate,@RequestParam boolean isCompleted)
    {
        logger.info("Going to update the Todo of id : {0} ",id);
        todoService.updateTodoByID(id,todo,targetDate,isCompleted);
        return "redirect:/list-todos";
    }
}
