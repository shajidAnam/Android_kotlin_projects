package com.example.assignment_11.feature.web_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment_11.R
import kotlinx.android.synthetic.main.activity_web_url.*

class WebUrlActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_url)
        val webUrl:String=intent.getStringExtra("website")!!
        website.loadUrl(webUrl)
    }
}