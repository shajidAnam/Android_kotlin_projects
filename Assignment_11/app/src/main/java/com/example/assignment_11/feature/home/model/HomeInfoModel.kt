package com.example.assignment_11.feature.home.model

import com.example.assignment_11.feature.home.model.HomeCallBack

interface HomeInfoModel {
    fun getBasicInfo(homeCallBack: HomeCallBack)
}