package com.mhl.practice.controller

import com.mhl.practice.entity.Users
import com.mhl.practice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @Autowired
    private lateinit var repository: UserRepository

    @PostMapping("/auth")
    fun auth(email: String, password: String): Users =
        repository.findByEmailAndPassword(email, password)

    @PostMapping("/createUser")
    fun createUser(@RequestBody user: Users):String {
        return try {
            repository.save(user)
            "Success"
        } catch (e: Exception) {
            "User exists"
        }
    }
    
}