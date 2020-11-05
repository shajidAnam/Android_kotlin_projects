package com.example.assignment_11.presenter.home

import android.view.View
import com.example.assignment_11.model.Information
import com.example.assignment_11.model.home.HomeCallBack
import com.example.assignment_11.model.home.HomeInfoModel
import com.example.assignment_11.model.home.HomeInfoModelImpl
import com.example.assignment_11.view.home.HomeInfoView

class HomePresenterImpl(private val View:HomeInfoView):HomePresenter {
    private val homeInfoModel:HomeInfoModel=HomeInfoModelImpl()
    override fun getInfo() {
        View.handleProgressbarVisibility(true)
        homeInfoModel.getBasicInfo(object :HomeCallBack{
            override fun onSuccess(information: Information) {
                View.handleProgressbarVisibility(false)
                View.onInfoFetchSuccess(information)
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