package com.learningapp.learning.cars

import com.learningapp.learning.SequenceService
import org.springframework.stereotype.Service


@Service
class CarService(private val carRepository: CarRepository, private val sequenceService: SequenceService) {

    fun setId() = sequenceService.next(Car::class)

    fun addCar(name: String): Car {
        val car = Car(setId(), name)
        return carRepository.save(car)
    }
    fun getAllCars(): List<Car> = carRepository.findAll()
    fun getCar(carId: Int) = carRepository.findById(carId)
    fun deleteCar(carId: Int) = carRepository.deleteById(carId)

}