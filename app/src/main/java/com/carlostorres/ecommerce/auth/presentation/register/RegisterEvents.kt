package com.carlostorres.ecommerce.auth.presentation.register

sealed interface RegisterEvents {

    data class OnNameChange(val name: String) : RegisterEvents
    data class OnLastNameChange(val lastName: String) : RegisterEvents
    data class OnPhoneChange(val phone : String) : RegisterEvents
    data class OnEmailChange(val email : String) : RegisterEvents
    data class OnPasswordChange(val password: String) : RegisterEvents
    data class OnConfirmPasswordChange(val password : String) : RegisterEvents

    object ValidateForm : RegisterEvents

}