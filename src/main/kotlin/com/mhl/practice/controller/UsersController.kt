package com.mhl.practice.controller

import com.mhl.practice.entity.Users
import com.mhl.practice.repository.UsersRepository
import jakarta.annotation.Nullable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UsersController {
    @Autowired
    private lateinit var repository: UsersRepository

    @Nullable
    @GetMapping("/auth")
    fun auth(
        @RequestParam("email") email: String,
        @RequestParam("password") password: String
    ): Users = repository.findByEmailAndPassword(email, password)


    @PostMapping("/createUser")
    fun createUser(@RequestBody user: Users): String {
        val foundUser = repository.findByEmail(user.email)
        if (foundUser == null) {
            repository.save(user)
            return "Successful"
        }
        return "User Exists"
    }

}