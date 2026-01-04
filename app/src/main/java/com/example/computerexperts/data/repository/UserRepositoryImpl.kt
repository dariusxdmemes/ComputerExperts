package com.example.computerexperts.data.repository

import com.example.computerexperts.data.remote.RetrofitClient
import com.example.computerexperts.data.remote.dto.CreateUserRequest
import com.example.computerexperts.domain.repository.UserRepository

class UserRepositoryImpl: UserRepository {
    override suspend fun register(
        nombre: String,
        apellidos: String,
        email: String,
        telefono: String
    ) {
        RetrofitClient.userApi.registerUser(
            CreateUserRequest(
                nombre = nombre,
                apellidos = apellidos,
                email = email,
                telefono = telefono
            )
        )
    }
}