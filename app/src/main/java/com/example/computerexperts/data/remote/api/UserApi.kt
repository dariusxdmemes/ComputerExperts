package com.example.computerexperts.data.remote.api

import com.example.computerexperts.data.remote.dto.CreateUserRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("users")
    suspend fun registerUser(
        @Body request: CreateUserRequest
    )
}