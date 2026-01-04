package com.example.computerexperts.domain.repository

interface UserRepository {
    suspend fun register(
        nombre: String,
        apellidos: String,
        email: String,
        telefono: String
    )
}