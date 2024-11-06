package com.carlostorres.ecommerce.presentation.auth.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val formErrorMsg: String? = null,
)
