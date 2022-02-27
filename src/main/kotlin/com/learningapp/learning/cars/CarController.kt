package com.learningapp.learning.cars

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("cars")
class CarsController(private val handler: CarsService) {

    @PostMapping("add")
    fun addCar(@RequestParam name: String): ResponseEntity<Car> {
        val car = handler.addCar((name))
        return ResponseEntity.status(201).body(car)
    }

    @GetMapping("all")
    fun getCars(): ResponseEntity<List<Car>> = ResponseEntity.ok(handler.getAllCars())

}