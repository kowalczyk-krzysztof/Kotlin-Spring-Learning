package com.learningapp.learning.cars

import com.learningapp.learning.SequenceService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CarsService(private val carRepository: CarRepository, private val sequenceService: SequenceService) {

    fun setId() = sequenceService.next(Car::class)

    fun addCar(name: String): Car {
        val car = Car()
        car.id = setId()
        car.name = name
        return carRepository.save(car)
    }
    fun getAllCars(): List<Car> = carRepository.findAll()
}