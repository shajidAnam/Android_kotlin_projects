package com.example.assignment_11.network

import com.example.assignment_11.feature.home.model.BasicInfo
import com.example.assignment_11.feature.login.model.LoginResponse
import com.example.assignment_11.feature.login.model.UserCredential
import com.example.assignment_11.feature.student.model.StudentResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("course_info.php")
    fun getBasicInfo():Call<BasicInfo>
    @POST("login.php")
    fun Login(@Body userCredential: UserCredential, @Header("api_key") apiKey:String):Call<LoginResponse>
    @GET("student.php")
    fun getStudent( @Header("api_key") apiKey:String,  @Header("token") token:String):Call<StudentResponse>
    @GET("student.php")
    fun getSingleStudent( @Header("api_key") apiKey:String,  @Header("token") token:String,@Query("id")id:Int):Call<StudentResponse>
}