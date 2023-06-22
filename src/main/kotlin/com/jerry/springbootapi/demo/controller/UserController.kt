package com.jerry.springbootapi.demo.controller

import com.jerry.springbootapi.demo.entity.User
import com.jerry.springbootapi.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @PostMapping("/user")
    fun createUser(@RequestBody user:User): User {
        return userRepository.save(
                user
        )
    }
}