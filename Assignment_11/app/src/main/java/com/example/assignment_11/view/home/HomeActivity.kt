package com.example.assignment_11.view.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.assignment_11.R
import com.example.assignment_11.WebUrlActivity
import com.example.assignment_11.core.BaseActivity
import com.example.assignment_11.model.Information
import com.example.assignment_11.presenter.home.HomePresenter
import com.example.assignment_11.presenter.home.HomePresenterImpl
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity : BaseActivity(),HomeInfoView{
    override fun setToolbar(): Toolbar {
        toolbar.title="Home"
        return toolbar
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_home
    }

    override val isHomeButtonEnabled: Boolean
        get() =false
    lateinit var homePresenter:HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homePresenter=HomePresenterImpl(this)
        homePresenter.getInfo()

    }

    override fun onInfoFetchSuccess(information: Information) {
//        Glide.with(iv_home_image)
//            .load(information.data.url)
//            .into(iv_home_image)
        tv_course_title.text=information.data.name
        tv_course_duration_value.text=information.data.class_duration
        tv_course_fee_value.text=information.data.fee
        tv_no_of_class_value.text=information.data.number_of_class.toString()
        tv_weburl_value.text=information.data.url
        tv_weburl_value.setOnClickListener {
            val intent=Intent(this,WebUrlActivity::class.java)
            intent.putExtra("website",information.data.url)
            startActivity(intent)
        }
        val adapter=HomeAdapter(information.data.class_days)
        recyclerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerview.adapter=adapter
    }

    override fun onInfoFetchError(errorMessage: String) {
        showShortToast(errorMessage)
    }

    override fun handleProgressbarVisibility(isVisible: Boolean) {
        if (isVisible)
            progressBar?.visibility=View.VISIBLE
        else
            progressBar?.visibility=View.GONE
    }

}