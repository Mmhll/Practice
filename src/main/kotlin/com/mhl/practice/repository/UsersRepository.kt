package com.mhl.practice.repository

import com.mhl.practice.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository: JpaRepository<Users, Int> {

    @Query("select * from users  where email = :email", nativeQuery = true)
    fun findByEmail(email: String): Users?

    @Query(value = "SELECT * FROM Users WHERE" +
            " Users.email = :email AND Users.password = :password",
        nativeQuery = true)
    fun findByEmailAndPassword(email: String, password: String): Users

}