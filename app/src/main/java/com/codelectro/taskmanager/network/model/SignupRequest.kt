package com.codelectro.taskmanager.network.model

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @SerializedName("username")
    var username: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("imageURL")
    var imageURL: String? = null
)