package com.learningapp.learning.cars

import com.learningapp.learning.SequenceService
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.Instant


@Service
class CarService(private val carRepository: CarRepository, private val sequenceService: SequenceService) {

    fun setId() = sequenceService.next(Car::class)

    fun addCar(carRequest: CarRequest): Car {
        val name = carRequest.name
        val description = carRequest.description
        val createdAt = Instant.now()
        val car = Car(setId(), name, description, createdAt)
        return carRepository.save(car)
    }
    fun getAllCars(): List<Car> = carRepository.findAll()
    fun getCar(carId: Int): Car? = carRepository.findByIdOrNull(carId)
    fun deleteCar(carId: Int): Car? {
        val car = carRepository.findByIdOrNull(carId)
        car ?: return null
        carRepository.delete(car)
        return car
    }

}