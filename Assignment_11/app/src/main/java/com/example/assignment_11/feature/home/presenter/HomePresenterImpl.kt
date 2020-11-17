package com.example.assignment_11.feature.home.presenter

import com.example.assignment_11.feature.home.model.BasicInfo
import com.example.assignment_11.feature.home.model.HomeCallBack
import com.example.assignment_11.feature.home.model.HomeInfoModel
import com.example.assignment_11.feature.home.model.HomeInfoModelImpl
import com.example.assignment_11.feature.home.view.HomeInfoView

class HomePresenterImpl(private val View: HomeInfoView): HomePresenter {
    private val homeInfoModel: HomeInfoModel = HomeInfoModelImpl()
    override fun getInfo() {
        View.handleProgressbarVisibility(true)
        homeInfoModel.getBasicInfo(object : HomeCallBack {
            override fun onSuccess(basicInfo: BasicInfo) {
                View.handleProgressbarVisibility(false)
                View.onInfoFetchSuccess(basicInfo)
            }

            override fun onError(throwable: Throwable) {
                View.handleProgressbarVisibility(false)
                if (throwable.localizedMessage!=null)
                    View.onInfoFetchError(throwable.localizedMessage)
                else
                    View.onInfoFetchError("Something went wrong")
            }

        })
    }
}