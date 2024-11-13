package com.carlostorres.ecommerce.auth.data.repository.datasource

import com.carlostorres.ecommerce.auth.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<User>

}