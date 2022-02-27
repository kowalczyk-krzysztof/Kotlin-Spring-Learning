package com.learningapp.learning.cars

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository: MongoRepository<Car, Int>