package com.learningapp.learning.cars

import com.learningapp.learning.SequenceService
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CarRepository: MongoRepository<Car, String> {
    fun findByName(name: String): Optional<Car>
}