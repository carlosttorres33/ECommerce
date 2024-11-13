package com.carlostorres.ecommerce.auth.data.repository

import com.carlostorres.ecommerce.auth.data.repository.datasource.AuthRemoteDataSource
import com.carlostorres.ecommerce.util.ResponseUI
import com.carlostorres.ecommerce.auth.domain.model.User
import com.carlostorres.ecommerce.auth.domain.repository.AuthRepository

class AuthRepositoryImpl (private val authRemoteDataSource: AuthRemoteDataSource) : AuthRepository {

    override suspend fun login(email: String, password: String): ResponseUI<User> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            ResponseUI.Success(result.body()!!)
        }catch (e:Exception) {
            e.printStackTrace()
            ResponseUI.Failure(e)
        }
    }

}