package com.learningapp.learning.cars

import com.learningapp.learning.utils.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("cars")
class CarController(private val carService: CarService) {

    @PostMapping("add")
    fun addCar(@RequestBody carRequest: CarRequest) = ResponseEntity.status(HttpStatus.CREATED).body(carService.addCar((carRequest)))

    @GetMapping("all")
    fun getCars() = ResponseEntity.ok(carService.getAllCars())

    @GetMapping("{carId}")
    fun getCar(@PathVariable("carId") carId: Int): ResponseEntity<Car> {
        val car = carService.getCar(carId)
        car ?: throw NotFoundException()
        return ResponseEntity.ok(car)
    }

    @DeleteMapping("delete/{carId}")
    fun deleteCar(@PathVariable("carId") carId: Int): ResponseEntity<String> {
        val car = carService.deleteCar(carId)
        car ?: throw NotFoundException()
        return ResponseEntity.ok("Deleted car with id: $carId")
    }
}
