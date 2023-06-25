package com.jerry.springbootapi.demo.controller

import com.jerry.springbootapi.demo.entity.User
import com.jerry.springbootapi.demo.repository.TodoRepository
import com.jerry.springbootapi.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {
    
    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var todoRepository: TodoRepository

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userService.getAllUser()
    }

//    @PostMapping("/addUser")
//    fun createUser(@RequestBody user:User): User {
//
//        return userRepository.save(
//                user
//        )
//    }
//
//    @PostMapping("/addUser2")
//    fun createUser2(@ModelAttribute user:User): User {
//        return userRepository.save(
//                user
//        )
//    }
//
//    @PostMapping("/addUser3")
//    fun createUser3(@RequestParam firstName: String , @RequestParam lastName: String): User {
//        return userRepository.save(
//                User(
//                        firstName = firstName,
//                        lastName = lastName,
//                        id = 0
//                )
//        )
//    }
//
//    @PostMapping("/addUser4")
//    fun createUser4(@RequestBody userDTO: UserDTO): User {
//
//        val user = userRepository.save(
//                User(
//                        firstName = userDTO.firstName,
//                        lastName = userDTO.firstName,
//                        id = 0
//                )
//        )
//
//        userDTO.todos.forEach {
//            todoRepository.save(
//                    Todo(
//                            user = user,
//                            task = it.task
//                    )
//            )
//        }
//
//        return user
//    }
}