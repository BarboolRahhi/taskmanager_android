package com.codelectro.taskmanager.di

import com.codelectro.taskmanager.network.AuthAPI
import com.codelectro.taskmanager.repository.AuthRepository
import com.codelectro.taskmanager.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(
        authAPI: AuthAPI
    ): AuthRepository {
        return AuthRepositoryImpl(authAPI)
    }
}