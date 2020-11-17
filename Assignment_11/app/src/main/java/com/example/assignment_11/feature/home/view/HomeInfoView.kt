package com.example.assignment_11.feature.home.view

import com.example.assignment_11.feature.home.model.BasicInfo

interface HomeInfoView {
    fun onInfoFetchSuccess(basicInfo: BasicInfo)
    fun onInfoFetchError(errorMessage:String)
    fun handleProgressbarVisibility(isVisible:Boolean)
}