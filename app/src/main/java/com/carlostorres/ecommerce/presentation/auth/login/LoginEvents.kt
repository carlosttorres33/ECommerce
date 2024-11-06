package com.carlostorres.ecommerce.presentation.auth.login

sealed interface LoginEvents {

    data class OnEmailChange(val email: String) : LoginEvents
    data class OnPasswordChange(val password: String) : LoginEvents

    data object ValidateForm : LoginEvents

}