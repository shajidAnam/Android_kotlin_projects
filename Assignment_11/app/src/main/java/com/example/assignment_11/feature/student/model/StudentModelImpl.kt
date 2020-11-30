package com.example.assignment_11.feature.student.model

import android.content.Context
import com.example.assignment_11.R
import com.example.assignment_11.core.DataFetchCallBack
import com.example.assignment_11.network.ApiInterface
import com.example.assignment_11.network.RetrofitClient
import com.example.assignment_11.shared_preference.SharedPreference
import com.example.assignment_11.shared_preference.SharedPreferenceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentModelImpl(private val context: Context):StudentModel {
    private val apiInterface=RetrofitClient.getClient().create(ApiInterface::class.java)
    private val sharedPreference=SharedPreferenceImpl(context)
    private val token=sharedPreference.getString(SharedPreference.TOKEN)
    override fun getStudentList(callBack: DataFetchCallBack<StudentResponse>) {
        val call=apiInterface.getStudent(context.getString(R.string.api_key), token!!)
        call.enqueue(object:Callback<StudentResponse>{
            override fun onResponse(
                call: Call<StudentResponse>,
                response: Response<StudentResponse>
            ) {
                response.body().let {
                    if (it != null) {
                        callBack.onSuccess(it)
                    }
                }
            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                callBack.onError(t)
            }

        })
    }

    override fun getSingleStudent(id: Int, callBack: DataFetchCallBack<StudentResponse>) {
        val call=apiInterface.getSingleStudent(context.getString(R.string.api_key),token!!,id)
        call.enqueue(object :Callback<StudentResponse>{
            override fun onResponse(
                call: Call<StudentResponse>,
                response: Response<StudentResponse>
            ) {
                response.body().let {
                    callBack.onSuccess(it!!)
                }
            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                callBack.onError(t)
            }

        })
    }
}