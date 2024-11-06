package com.carlostorres.ecommerce.presentation.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(

): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    private fun validateForm(){
        if (state.name.isEmpty() || state.lastName.isEmpty() || state.phone.isEmpty() || state.email.isEmpty() || state.password.isEmpty() || state.confirmPassword.isEmpty()){
            state = state.copy(formErrorMsg = "Todos los campos son obligatorios")
        }else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            state = state.copy(formErrorMsg = "Email inválido")
        } else if (state.password.length < 6) {
            state = state.copy(formErrorMsg = "La contraseña debe tener al menos 6 caracteres")
        } else if (state.password != state.confirmPassword){
            state = state.copy(formErrorMsg = "Las contraseñas no coinciden")
        }else{
            state = state.copy(formErrorMsg = null)
        }
    }

    fun onEvent(event: RegisterEvents){
        when(event){
            is RegisterEvents.OnNameChange -> {
                state = state.copy(name = event.name)
            }
            is RegisterEvents.OnLastNameChange -> {
                state = state.copy(lastName = event.lastName)
            }
            is RegisterEvents.OnPhoneChange -> {
                state = state.copy(phone = event.phone)
            }
            is RegisterEvents.OnEmailChange -> {
                state = state.copy(email = event.email)
            }
            is RegisterEvents.OnPasswordChange -> {
                state = state.copy(password = event.password)
            }
            is RegisterEvents.OnConfirmPasswordChange -> {
                state = state.copy(confirmPassword = event.password)
            }

            RegisterEvents.ValidateForm -> validateForm()
        }
    }

}