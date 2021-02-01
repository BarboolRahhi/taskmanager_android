package com.codelectro.taskmanager.repository

import com.codelectro.taskmanager.network.AuthAPI
import com.codelectro.taskmanager.network.Resource
import com.codelectro.taskmanager.network.model.MessageResponse
import com.codelectro.taskmanager.network.model.SignupRequest

class AuthRepositoryImpl(
    private val authApi: AuthAPI
) : AuthRepository, BaseRepository() {

    override suspend fun signup(signupRequest: SignupRequest): Resource<MessageResponse> {
        return safeApiCall {
            authApi.signup(signupRequest)
        }
    }

    override suspend fun getHey(): Resource<MessageResponse> {
        return safeApiCall {
            authApi.getHey()
        }
    }
}