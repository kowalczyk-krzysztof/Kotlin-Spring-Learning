package com.learningapp.learning.cars

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "cars")
class Car(@Id val id: Int, val name: String)