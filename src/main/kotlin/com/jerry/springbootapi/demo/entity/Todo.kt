package com.jerry.springbootapi.demo.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table
data class Todo (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0 ,

        @Column(name = "task")
        val task: String? = null,

        @JsonIgnore //ignore it will not show on json result
      //  @JsonIgnoreProperties("todos") // ignore the user property when serializing to JSON
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        var user: User
)
