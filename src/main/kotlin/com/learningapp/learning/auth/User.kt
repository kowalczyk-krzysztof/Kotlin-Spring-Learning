package com.learningapp.learning.auth

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(
    @Id
    val id: Int,
    val login: String,
    val password: String,
)