package com.mhl.practice.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data

@Entity(name = "users")
@Data
data class Users(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val email: String,
    val password: String,
    @Column(name = "full_name")
    val fullName: String
)


