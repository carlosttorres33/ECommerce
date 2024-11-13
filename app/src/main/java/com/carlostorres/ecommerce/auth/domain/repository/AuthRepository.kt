package com.carlostorres.ecommerce.auth.domain.repository

import com.carlostorres.ecommerce.util.ResponseUI
import com.carlostorres.ecommerce.auth.domain.model.User

interface AuthRepository {

    suspend fun login(email: String, password: String): ResponseUI<User>

}