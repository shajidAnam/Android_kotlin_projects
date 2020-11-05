package com.example.assignment_11.network

import com.example.assignment_11.model.Information
import retrofit2.Call
import retrofit2.http.GET

interface HomeApiInterface {
    @GET("course_info.php")
    fun getBasicInfo():Call<Information>
}