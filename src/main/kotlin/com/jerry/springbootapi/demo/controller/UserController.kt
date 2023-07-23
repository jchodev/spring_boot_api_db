package com.jerry.springbootapi.demo.controller

import com.jerry.springbootapi.demo.dto.UserDTO
import com.jerry.springbootapi.demo.entity.User
import com.jerry.springbootapi.demo.repository.TodoRepository
import com.jerry.springbootapi.demo.response.MyResponse
import com.jerry.springbootapi.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController {
    
    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var todoRepository: TodoRepository

//    @GetMapping
//    fun getAllUsers(): List<User> {
//        return userService.getAllUser()
//    }

    @GetMapping
    fun getAllUsersByPage(@RequestParam pageNumber: Int): Page<User> {
        return userService.getUserByPage(page = pageNumber)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): MyResponse<User?> {
        val user = userService.getUserById(id = id)
        return MyResponse.success(user)
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(e: NotFoundException): MyResponse<Nothing> {
        return MyResponse.error(HttpStatus.NOT_FOUND, e.message!!)
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
    @PostMapping("/addUser")
    fun createUser(@RequestBody userDTO: UserDTO): User {
        return userService.createUser(userDTO)
    }
}