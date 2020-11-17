package com.example.assignment_11.feature.login.model
import java.io.Serializable
data class LoginResponse(
    val message: String,
    val status: Boolean,
    val token: String
):Serializable

