package com.carlostorres.ecommerce.auth.presentation.login

import com.carlostorres.ecommerce.auth.domain.model.User
import com.carlostorres.ecommerce.util.ResponseUI

data class LoginState(
    val email: String = "",
    val password: String = "",
    val formErrorMsg: String? = null,
    val loginResponse: ResponseUI<User>? = null
)
