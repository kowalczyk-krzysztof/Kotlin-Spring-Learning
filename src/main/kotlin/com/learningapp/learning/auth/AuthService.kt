package com.learningapp.learning.auth

import com.learningapp.learning.SequenceService
import com.learningapp.learning.utils.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AuthService(private val authRepository: AuthRepository, private val sequenceService: SequenceService
) {
    val passwordEncoder = BCryptPasswordEncoder()
    fun setId() = sequenceService.next(User::class)

    fun register(registerRequest: RegisterRequest): User? {
        val user = authRepository.existsByLogin(registerRequest.login)
        val login = registerRequest.login
        val password = passwordEncoder.encode(registerRequest.password)
        if (user) throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        val userToSave = User(id = setId(), login = login, password = password)
        return authRepository.save(userToSave)
    }
    fun login() {}
}

























