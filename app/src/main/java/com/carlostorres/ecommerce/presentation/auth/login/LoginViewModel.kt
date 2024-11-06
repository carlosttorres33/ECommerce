package com.carlostorres.ecommerce.presentation.auth.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.intellij.lang.annotations.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    private fun validateForm(){

        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            state = state.copy(formErrorMsg = "Email inválido")
        } else if (state.password.length < 6){
            state = state.copy(formErrorMsg = "La contraseña debe tener al menos 6 caracteres")
        } else {
            state = state.copy(formErrorMsg = null)
        }

    }

    fun onEvent(event: LoginEvents) {
        when(event){
            is LoginEvents.OnEmailChange -> {
                state = state.copy(email = event.email)
            }
            is LoginEvents.OnPasswordChange -> {
                state = state.copy(password = event.password)
            }
            LoginEvents.ValidateForm -> {
                validateForm()
            }
        }
    }

}