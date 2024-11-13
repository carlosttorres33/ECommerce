package com.carlostorres.ecommerce.auth.presentation.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlostorres.ecommerce.auth.domain.usecase.AuthUseCase
import com.carlostorres.ecommerce.util.ResponseUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCases: AuthUseCase
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun login() {

        if (isValidForm()) {
            viewModelScope.launch {
                state = state.copy(
                    loginResponse = ResponseUI.Loading
                )

                val result = useCases.loginUseCase(
                    email = state.email,
                    password = state.password
                )

                state = state.copy(
                    loginResponse = result
                )
                Log.d("LoginViewModel", "Response: $result")

            }
        }
    }

    private fun isValidForm(): Boolean {

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            state = state.copy(formErrorMsg = "Email inválido")
            return false
        } else if (state.password.length < 6) {
            state = state.copy(formErrorMsg = "La contraseña debe tener al menos 6 caracteres")
            return false
        } else {
            state = state.copy(formErrorMsg = null)
            return true
        }

    }

    fun onEvent(event: LoginEvents) {
        when (event) {
            is LoginEvents.OnEmailChange -> {
                state = state.copy(email = event.email)
            }
            is LoginEvents.OnPasswordChange -> {
                state = state.copy(password = event.password)
            }
            LoginEvents.IsValidForm -> {
                login()
            }
        }
    }

}