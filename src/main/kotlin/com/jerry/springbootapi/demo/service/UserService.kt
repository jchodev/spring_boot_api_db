package com.jerry.springbootapi.demo.service

import com.jerry.springbootapi.demo.dto.UserDTO
import com.jerry.springbootapi.demo.entity.Todo
import org.slf4j.Logger
import com.jerry.springbootapi.demo.entity.User
import com.jerry.springbootapi.demo.exception.DataNotFoundException
import com.jerry.springbootapi.demo.repository.TodoRepository
import com.jerry.springbootapi.demo.repository.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
@CacheConfig(cacheNames = ["users"])
class UserService {

    @Autowired //like Dagger @Inject
    private lateinit var logger: Logger

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var todoRepository: TodoRepository

    @Cacheable
    fun getUserById(id: Long): User? {
        println("Fetching user with id $id")
        return userRepository.findById(id).orElseThrow {
            DataNotFoundException(id = id)
        }
    }

    @Cacheable
    fun getAllUser(): List<User> {
        logger.info("Fetching get All uSer")
        return userRepository.findAll()
    }


    @Cacheable
    fun getUserByPage(page: Int): Page<User> {
        logger.info("Fetching get User By Page")
        val sort = Sort.by(
                Sort.Order.asc("firstName"),
                Sort.Order.desc("id")
        )
        val pageable = PageRequest.of(page, 5, sort)
        return userRepository.
            findAll(pageable)
    }

    @CachePut
    fun createUser(@RequestBody userDTO: UserDTO): User {
        val user = userRepository.save(
                User(
                        firstName = userDTO.firstName,
                        lastName = userDTO.firstName,
                        id = 0
                )
        )

        userDTO.todos.forEach {
            todoRepository.save(
                    Todo(
                            user = user,
                            task = it.task
                    )
            )
        }

        return user
    }

    @CachePut
    fun saveUser(user: User): User {
        println("Saving user with id ${user.id}")
        return userRepository.save(user)
    }

    @CacheEvict
    fun deleteUserById(id: Long) {
        println("Deleting user with id $id")
        userRepository.deleteById(id)
    }
}