package com.learningapp.learning.cars

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("cars")
class CarsController(private val carService: CarService) {

    @PostMapping("add")
    fun addCar(@RequestParam name: String) = ResponseEntity.status(201).body(carService.addCar((name)))

    @GetMapping("all")
    fun getCars() = ResponseEntity.ok(carService.getAllCars())

    @GetMapping("{carId}")
    fun getCar(@PathVariable("carId") carId: Int) = ResponseEntity.ok(carService.getCar(carId))

    @DeleteMapping("delete/{carId}")
    fun deleteCar(@PathVariable("carId") carId: Int) = ResponseEntity.ok(carService.deleteCar(carId))
}