package com.codelectro.taskmanager.network

import com.codelectro.taskmanager.network.model.MessageResponse
import com.codelectro.taskmanager.network.model.SignupRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthAPI {

    @POST("auth/signup")
    suspend fun signup(@Body request: SignupRequest): MessageResponse

    @GET("auth/hi")
    suspend fun getHey(): MessageResponse

}
