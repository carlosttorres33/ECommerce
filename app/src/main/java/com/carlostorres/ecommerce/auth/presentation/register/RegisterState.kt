package com.carlostorres.ecommerce.auth.presentation.register

data class RegisterState(
    val name: String = "",
    val lastName: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val formErrorMsg: String? = null,
)
