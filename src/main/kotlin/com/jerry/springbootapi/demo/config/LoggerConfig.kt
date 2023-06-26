package com.jerry.springbootapi.demo.config


import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class LoggerConfig {

    @Bean
    fun logger(): Logger {
        return LoggerFactory.getLogger(javaClass)
    }

//    @Value("classpath:log4j2.properties")
//    var resourceFile: Resource? = null
//
//    @Bean
//    fun initialLog4j2(){
//        val context = LogManager.getContext(false) as LoggerContext
//        context.configLocation = javaClass.getResource("log4j2.properties").toURI()
//
//    }

//    @Bean
//    fun logger(): Logger {
//        //val context = LogManager.getContext(false) as LoggerContext
//       // context.configLocation = javaClass.getResource("log4j2.properties").toURI()
//
//        return LogManager.getLogger(javaClass)
//    }

//    @Bean
//    fun getLoggerContext(): LoggerContext? {
//        return LoggerFactory.getILoggerFactory() as LoggerContext
//    }
}