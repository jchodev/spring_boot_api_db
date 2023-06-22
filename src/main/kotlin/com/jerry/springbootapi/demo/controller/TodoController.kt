package com.jerry.springbootapi.demo.controller

import com.jerry.springbootapi.demo.entity.Todo
import com.jerry.springbootapi.demo.entity.User
import com.jerry.springbootapi.demo.repository.TodoRepository
import com.jerry.springbootapi.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController {
    
    @Autowired
    lateinit var todoRepository: TodoRepository

    @GetMapping("/todos")
    fun getAllTodos(): List<Todo> {
        return todoRepository.findAll()
    }

    @PostMapping("/todo")
    fun createTodo(@RequestBody todo:Todo): Todo {
        return todoRepository.save(
                todo
        )
    }
}