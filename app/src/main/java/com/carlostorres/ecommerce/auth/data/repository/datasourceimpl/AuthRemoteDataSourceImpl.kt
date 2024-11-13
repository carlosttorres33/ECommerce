package com.carlostorres.ecommerce.auth.data.repository.datasourceimpl

import com.carlostorres.ecommerce.auth.data.repository.datasource.AuthRemoteDataSource
import com.carlostorres.ecommerce.auth.data.service.AuthService
import com.carlostorres.ecommerce.auth.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl (private val authService: AuthService) : AuthRemoteDataSource {

    override suspend fun login(email: String, password: String): Response<User> = authService.login(email, password)

}