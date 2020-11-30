package com.example.assignment_11.core

interface DataFetchCallBack<T> {
    fun onSuccess(data:T)
    fun onError(throwable: Throwable)
}