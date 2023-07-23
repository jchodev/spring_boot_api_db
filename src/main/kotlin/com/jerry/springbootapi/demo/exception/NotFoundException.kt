package com.jerry.springbootapi.demo.exception

class DataNotFoundException(id: Long) : RuntimeException("Data $id not found")