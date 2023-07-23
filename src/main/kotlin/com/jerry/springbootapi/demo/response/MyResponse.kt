package com.jerry.springbootapi.demo.response

import org.springframework.http.HttpStatus

data class MyResponse<T>(
        val code: Int,
        val errorMessage: String? = null,
        val data: T? = null
) {
    companion object {
        fun <T> success(data: T): MyResponse<T> =
                MyResponse(HttpStatus.OK.value(), null , data)

        fun error(status: HttpStatus, message: String): MyResponse<Nothing> =
                MyResponse(status.value(), message)
    }
}