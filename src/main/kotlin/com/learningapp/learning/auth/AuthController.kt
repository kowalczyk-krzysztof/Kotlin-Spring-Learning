package com.learningapp.learning.auth

import com.learningapp.learning.utils.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
class AuthController(private val authService: AuthService) {
    @PostMapping("register")
    fun register(@RequestBody registerRequest: RegisterRequest): ResponseEntity<User> {
        val user = authService.register(registerRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(user)
    }
    fun login() {}
}