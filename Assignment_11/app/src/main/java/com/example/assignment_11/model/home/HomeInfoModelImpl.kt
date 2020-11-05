package com.example.assignment_11.model.home

import com.example.assignment_11.model.Information
import com.example.assignment_11.network.HomeApiInterface
import com.example.assignment_11.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class HomeInfoModelImpl():HomeInfoModel {
    val apiInterface=RetrofitClient.getClient().create(HomeApiInterface::class.java)
    override fun getBasicInfo(homeCallBack: HomeCallBack) {
        val call=apiInterface.getBasicInfo()
        call.enqueue(object :Callback<Information>{
            override fun onResponse(call: Call<Information>, response: Response<Information>) {
                response.body()?.let {
                    homeCallBack.onSuccess(it)
                }
            }

            override fun onFailure(call: Call<Information>, t: Throwable) {
                homeCallBack.onError(t)
            }

        })
    }
}