package com.example.assignment_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.assignment_11.core.BaseActivity
import kotlinx.android.synthetic.main.activity_web_url.*
import kotlinx.android.synthetic.main.toolbar.*

class WebUrlActivity : BaseActivity(){
    override fun setToolbar(): Toolbar {
        toolbar.title="website"
        return toolbar
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_web_url
    }

    override val isHomeButtonEnabled: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webUrl:String=intent.getStringExtra("website")
        website.loadUrl(webUrl)
    }
}