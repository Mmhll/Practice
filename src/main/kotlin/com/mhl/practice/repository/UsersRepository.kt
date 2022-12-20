package com.mhl.practice.repository

import com.mhl.practice.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<Users, Int> {
//    @Query(value = "SELECT * FROM Users WHERE" +
//            " Users.email = '?1'",
//        nativeQuery = true)
//    fun findByEmail(email: String?): UserEntity
    @Query(value = "SELECT * FROM Users WHERE" +
            " Users.email = '?1' AND Users.password = '?2'",
        nativeQuery = true)
    fun findByEmailAndPassword(email: String, password: String): Users

    @Query(value = "INSERT INTO users (email, full_name, password) VALUES (?,?,?)", nativeQuery = true)
    fun save(users: Users)
}