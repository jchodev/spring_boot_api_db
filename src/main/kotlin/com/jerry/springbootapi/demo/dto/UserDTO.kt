package com.jerry.springbootapi.demo.dto


data class UserDTO (
        val firstName: String? = null,
        val lastName: String? = null,
        val todos : List<TodoDTO> = listOf()
)