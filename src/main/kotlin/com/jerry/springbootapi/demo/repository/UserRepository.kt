package com.jerry.springbootapi.demo.repository

import com.jerry.springbootapi.demo.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>