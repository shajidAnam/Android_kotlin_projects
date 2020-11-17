package com.example.assignment_11.feature.login.view

import com.example.assignment_11.feature.login.model.LoginResponse

interface LoginView {
    fun onDataFetchSuccess(loginResponse: LoginResponse)
    fun onDataFetchError(errorMessage:String)
}