package com.jerry.springbootapi.demo


import com.jerry.springbootapi.demo.controller.UserController
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


//@ExtendWith(SpringExtension::class)
//@SpringBootTest
//class DemoApplicationTest {
//
//    @Autowired
//    var userController: UserController? = null
//
//    @Test
//    fun contextLoads() {
//        Assertions.assertThat(userController).isNot(null)
//    }
//}