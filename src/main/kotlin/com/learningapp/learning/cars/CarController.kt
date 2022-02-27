package com.learningapp.learning.cars

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("cars")
class CarController(private val carService: CarService) {

    @PostMapping("add")
    fun addCar(@RequestBody carRequest: CarRequest) = ResponseEntity.status(201).body(carService.addCar((carRequest)))

    @GetMapping("all")
    fun getCars() = ResponseEntity.ok(carService.getAllCars())

    @GetMapping("{carId}")
    fun getCar(@PathVariable("carId") carId: Int) = ResponseEntity.ok(carService.getCar(carId))

    @DeleteMapping("delete/{carId}")
    fun deleteCar(@PathVariable("carId") carId: Int) = ResponseEntity.ok(carService.deleteCar(carId))
}