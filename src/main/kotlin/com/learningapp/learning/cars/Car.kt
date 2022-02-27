package com.learningapp.learning.cars

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "cars")
class Car(@Id val id: Int, val name: String, val description: String?, val createdAt: Instant)