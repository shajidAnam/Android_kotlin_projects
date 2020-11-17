package com.example.assignment_11.feature.login.model

import com.example.assignment_11.core.DataFetchCallBack

interface LoginModel {
    fun login(userCredential: UserCredential,callBack: DataFetchCallBack<LoginResponse>)
}