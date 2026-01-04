package com.example.computerexperts.ui.register

data class RegisterState(
    val nombre: String = "",
    val apellidos: String = "",
    val email: String = "",
    val telefono: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)
