package com.jerry.springbootapi.demo.service

import com.jerry.springbootapi.demo.entity.User
import com.jerry.springbootapi.demo.exception.DataNotFoundException
import com.jerry.springbootapi.demo.repository.UserRepository
import org.junit.Assert
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*


//https://howtodoinjava.com/spring-boot2/testing/spring-boot-2-junit-5/
@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @InjectMocks
    lateinit var userService: UserService

    @Mock
    lateinit var userRepository: UserRepository

    @Test
    fun `find by id expected success`(){

        val id = 1L

        val user = User(
                id = id,
                firstName = "",
                lastName = "",
                todos = emptyList()
        )

        //assign
        `when`(userRepository.findById(id)).thenReturn(Optional.of(
                user
        ))

        //test
        val result = userService.getUserById(id)

        Assert.assertEquals(0, result?.todos?.size)
    }

    @Test
    fun `find by id expected throws DataNotFoundException`(){

        val id = 1L

        //assign
        `when`(userRepository.findById(id)).thenThrow(DataNotFoundException::class.java)

        //test
        val throwable: Throwable = assertThrows(DataNotFoundException::class.java) {  userService.getUserById(id) }

        assertEquals(DataNotFoundException::class.java, throwable.javaClass)

    }

}