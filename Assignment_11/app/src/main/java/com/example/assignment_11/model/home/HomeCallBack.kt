package com.example.assignment_11.model.home

import com.example.assignment_11.model.Information

interface HomeCallBack {
    fun onSuccess(information:Information)
    fun onError(throwable: Throwable)
}