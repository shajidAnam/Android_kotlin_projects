package com.example.assignment_11.shared_preference

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceImpl(context: Context):SharedPreference {
    private val sharedPreference=context.getSharedPreferences("sharedPreference",Context.MODE_PRIVATE)
    private val editor=sharedPreference.edit()
    override fun getString(key: String): String? {
        return sharedPreference.getString(key,"")
    }

    override fun setString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    override fun getBoolean(key: String): Boolean? {
        return sharedPreference.getBoolean(key,false)
    }

    override fun setBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

}