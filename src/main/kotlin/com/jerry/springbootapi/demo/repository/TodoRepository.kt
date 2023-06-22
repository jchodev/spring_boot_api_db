package com.jerry.springbootapi.demo.repository

import com.jerry.springbootapi.demo.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface  TodoRepository: JpaRepository<Todo, Long>