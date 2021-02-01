package com.codelectro.taskmanager.repository

import com.codelectro.taskmanager.network.Resource
import com.codelectro.taskmanager.network.model.MessageResponse
import com.codelectro.taskmanager.network.model.SignupRequest

interface AuthRepository {
    suspend fun signup(signupRequest: SignupRequest): Resource<MessageResponse>
    suspend fun getHey(): Resource<MessageResponse>
}