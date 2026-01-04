package com.example.computerexperts.ui.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.computerexperts.data.repository.UserRepositoryImpl
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel() {
    private val repo = UserRepositoryImpl()

    var state by mutableStateOf(RegisterState())
        private set

    fun onNombreChange(value: String) {
        state = state.copy(nombre = value)
    }

    fun onApellidosChange(value: String) {
        state = state.copy(apellidos = value)
    }

    fun onEmailChange(value: String) {
        state = state.copy(email = value)
    }

    fun onTelefonoChange(value: String) {
        state = state.copy(telefono = value)
    }

    fun submit() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            try {
                repo.register(
                    nombre = state.nombre,
                    apellidos = state.apellidos,
                    email = state.email,
                    telefono = state.telefono
                )

                state = state.copy(
                    isLoading = false,
                    success = true
                )
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    error = e.message ?: "Error"
                )
            }
        }
    }
}