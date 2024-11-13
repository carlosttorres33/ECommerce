package com.carlostorres.ecommerce.auth.presentation.login

sealed interface LoginEvents {

    data class OnEmailChange(val email: String) : LoginEvents
    data class OnPasswordChange(val password: String) : LoginEvents

    data object IsValidForm : LoginEvents

}