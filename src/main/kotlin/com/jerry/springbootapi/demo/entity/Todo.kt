package com.jerry.springbootapi.demo.entity

import javax.persistence.*

@Entity
@Table
data class Todo (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(name = "task")
        val task: String? = null

)
