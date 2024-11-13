package com.carlostorres.ecommerce.auth.di

import com.carlostorres.ecommerce.auth.data.repository.AuthRepositoryImpl
import com.carlostorres.ecommerce.core.Config.BASE_URL
import com.carlostorres.ecommerce.auth.data.repository.datasource.AuthRemoteDataSource
import com.carlostorres.ecommerce.auth.data.repository.datasourceimpl.AuthRemoteDataSourceImpl
import com.carlostorres.ecommerce.auth.data.service.AuthService
import com.carlostorres.ecommerce.auth.domain.repository.AuthRepository
import com.carlostorres.ecommerce.auth.domain.usecase.AuthUseCase
import com.carlostorres.ecommerce.auth.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthNetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    @Provides
    @Singleton
    fun provideAuthService(
        retrofit: Retrofit
    ): AuthService = retrofit.create(AuthService::class.java)
    
    @Provides
    @Singleton
    fun provideAuthRemoteDataSource(
        authService: AuthService
    ): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)
    
    @Provides
    @Singleton
    fun provideAuthRepository(
        remoteDataSource: AuthRemoteDataSource
    ): AuthRepository = AuthRepositoryImpl(remoteDataSource)

    @Provides
    @Singleton
    fun provideAuthUseCases(
        authRepository: AuthRepository
    ): AuthUseCase{

        return AuthUseCase(
            loginUseCase = LoginUseCase(authRepository)
        )

    }

}