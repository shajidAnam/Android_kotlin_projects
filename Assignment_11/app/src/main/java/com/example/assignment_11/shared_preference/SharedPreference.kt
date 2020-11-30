package com.example.assignment_11.shared_preference

interface SharedPreference {
    companion object{
        const val TOKEN="token"
        const val LOGIN_STATUS="loginStatus"
    }
    fun getString(key:String):String?
    fun setString(key: String,value:String)
    fun getBoolean(key:String):Boolean?
    fun setBoolean(key: String,value:Boolean)
}