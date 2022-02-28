package com.learningapp.learning.auth

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthRepository: MongoRepository<User, Int> {
    fun existsByLogin(login: String): Boolean
}