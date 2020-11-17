package com.example.assignment_11.feature.login.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserCredential (
    @SerializedName("user_id")
    val userId:String,
    val password:String
):Serializable