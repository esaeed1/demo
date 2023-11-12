package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ThymeleafController {

    TodoRepository todoRepository;
    public ThymeleafController(TodoRepository todoRepo) {
        this.todoRepository = todoRepo;

    }

    @GetMapping("/form")
    public String getTodos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        model.addAttribute("newTodo", new Todo());
        return "index";
    }
}
