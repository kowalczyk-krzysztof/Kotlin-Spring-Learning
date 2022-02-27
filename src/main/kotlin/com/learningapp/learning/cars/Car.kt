package com.learningapp.learning.cars

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "cars")
class Car {
    @Id
    var id = 0
    var name = ""
}