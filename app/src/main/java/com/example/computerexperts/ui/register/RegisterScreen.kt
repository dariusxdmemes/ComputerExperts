package com.example.computerexperts.ui.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.computerexperts.R

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = viewModel()
) {
    val state = viewModel.state

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            stringResource(R.string.app_name)
        )
        Text(
            stringResource(R.string.register_title)
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        CardForm(
            modifier = Modifier.fillMaxWidth(),
            nombre = state.nombre,
            apellidos = state.apellidos,
            email = state.email,
            telefono = state.telefono,
            isLoading = state.isLoading,
            onNombreChange = viewModel::onNombreChange,
            onApellidosChange = viewModel::onApellidosChange,
            onEmailChange = viewModel::onEmailChange,
            onTelefonoChange = viewModel::onTelefonoChange,
            onSubmit = viewModel::submit
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun CardForm(
    modifier: Modifier = Modifier,
    nombre: String,
    apellidos: String,
    email: String,
    telefono: String,
    isLoading: Boolean,
    onNombreChange: (String) -> Unit,
    onApellidosChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onTelefonoChange: (String) -> Unit,
    onSubmit: () -> Unit
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = onNombreChange,
                label = {
                    Text(
                        stringResource(R.string.name_placeholder)
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = apellidos,
                onValueChange = onApellidosChange,
                label = {
                    Text(
                        stringResource(R.string.surname_placeholder)
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = email,
                onValueChange = onEmailChange,
                label = {
                    Text(
                        stringResource(R.string.email_placeholder)
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = telefono,
                onValueChange = onTelefonoChange,
                label = {
                    Text(
                        stringResource(R.string.phone_placeholder)
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Button(
                onClick = onSubmit,
                enabled = !isLoading,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    if (isLoading) "Registrando..." else "Sign up"
                )
            }
        }
    }
}