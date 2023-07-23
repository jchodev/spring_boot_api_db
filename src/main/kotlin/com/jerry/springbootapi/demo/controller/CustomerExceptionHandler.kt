package com.jerry.springbootapi.demo.controller

import com.jerry.springbootapi.demo.response.MyResponse
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class CustomerExceptionHandler {

    @ExceptionHandler(ChangeSetPersister.NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(e: ChangeSetPersister.NotFoundException): MyResponse<Nothing> {
        return MyResponse.error(HttpStatus.NOT_FOUND, e.message!!)
    }
    
}