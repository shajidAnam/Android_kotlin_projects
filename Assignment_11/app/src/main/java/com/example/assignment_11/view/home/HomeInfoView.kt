package com.example.assignment_11.view.home

import com.example.assignment_11.model.Information

interface HomeInfoView {
    fun onInfoFetchSuccess(information: Information)
    fun onInfoFetchError(errorMessage:String)
    fun handleProgressbarVisibility(isVisible:Boolean)
}