package com.example.assignment_11.feature.home.model

interface HomeCallBack {
    fun onSuccess(basicInfo: BasicInfo)
    fun onError(throwable: Throwable)
}