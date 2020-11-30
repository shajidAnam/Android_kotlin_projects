package com.example.assignment_11.feature.login.model

import android.content.Context
import com.example.assignment_11.R
import com.example.assignment_11.core.DataFetchCallBack
import com.example.assignment_11.network.ApiInterface
import com.example.assignment_11.network.RetrofitClient
import com.example.assignment_11.shared_preference.SharedPreference
import com.example.assignment_11.shared_preference.SharedPreferenceImpl
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModelImpl(private val context: Context) : LoginModel {
    private var sharedPreferences: SharedPreference = SharedPreferenceImpl(context)
    private val apiInterface = RetrofitClient.getClient().create(ApiInterface::class.java)
    override fun login(userCredential: UserCredential, callBack: DataFetchCallBack<LoginResponse>) {
        val api_key = context.getString(R.string.api_key)
        val call = apiInterface.Login(userCredential, api_key)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                response.body()?.let {
                    sharedPreferences.setString(SharedPreference.TOKEN, it.token)
                    sharedPreferences.setBoolean(SharedPreference.LOGIN_STATUS, it.status)
                    callBack.onSuccess(it)
                }
                response.errorBody()?.let {
                    val gson = Gson()
                    val obj = gson.fromJson(it.string(), LoginResponse::class.java)
                    callBack.onSuccess(obj)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                callBack.onError(t)
            }

        })
    }
}