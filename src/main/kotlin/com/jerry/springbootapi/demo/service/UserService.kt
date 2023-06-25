package com.jerry.springbootapi.demo.service

import com.jerry.springbootapi.demo.entity.User
import com.jerry.springbootapi.demo.repository.UserRepository
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable

import org.springframework.stereotype.Service

@Service
@CacheConfig(cacheNames = ["users"])
class UserService() {

    @Autowired //like Dagger @Inject
    private lateinit var logger: Logger

    @Autowired
    private lateinit var userRepository: UserRepository

    @Cacheable
    fun getUserById(id: Long): User? {
        println("Fetching user with id $id")
        return userRepository.findById(id).orElse(null)
    }

    @Cacheable
    fun getAllUser(): List<User> {
        logger.info("Fetching get All uSer")
        return userRepository.findAll()
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