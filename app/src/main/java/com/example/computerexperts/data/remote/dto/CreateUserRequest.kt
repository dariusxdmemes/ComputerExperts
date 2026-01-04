package com.example.computerexperts.data.remote.dto

data class CreateUserRequest(
    val nombre: String,
    val apellidos: String,
    val email: String,
    val telefono: String
)
