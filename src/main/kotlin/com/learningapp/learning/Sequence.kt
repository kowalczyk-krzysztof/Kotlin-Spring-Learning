package com.learningapp.learning

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "sequence")
data class Sequence(
    @Id
    val id: String,
    val seq: Int
)
