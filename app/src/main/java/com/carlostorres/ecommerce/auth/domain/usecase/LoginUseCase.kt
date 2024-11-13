package com.carlostorres.ecommerce.auth.domain.usecase

import com.carlostorres.ecommerce.auth.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = authRepository.login(email, password)

}