package com.example.assignment_11.feature.home.model

import com.example.assignment_11.network.ApiInterface
import com.example.assignment_11.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeInfoModelImpl(): HomeInfoModel {
    val apiInterface=RetrofitClient.getClient().create(ApiInterface::class.java)
    override fun getBasicInfo(homeCallBack: HomeCallBack) {
        val call=apiInterface.getBasicInfo()
        call.enqueue(object :Callback<BasicInfo>{
            override fun onResponse(call: Call<BasicInfo>, response: Response<BasicInfo>) {
                response.body()?.let {
                    homeCallBack.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<BasicInfo>, t: Throwable) {
                homeCallBack.onError(t)
            }

        })
    }
}