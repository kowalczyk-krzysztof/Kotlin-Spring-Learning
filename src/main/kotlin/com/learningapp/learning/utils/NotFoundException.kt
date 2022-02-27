package com.learningapp.learning.utils

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class NotFoundException: ResponseStatusException(HttpStatus.NOT_FOUND)