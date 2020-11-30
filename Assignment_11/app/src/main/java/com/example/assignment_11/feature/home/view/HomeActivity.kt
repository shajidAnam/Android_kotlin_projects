package com.example.assignment_11.feature.home.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_11.R
import com.example.assignment_11.feature.web_view.WebUrlActivity
import com.example.assignment_11.core.BaseActivity
import com.example.assignment_11.feature.home.model.BasicInfo
import com.example.assignment_11.feature.home.presenter.HomePresenter
import com.example.assignment_11.feature.home.presenter.HomePresenterImpl
import com.example.assignment_11.feature.login.view.LoginActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity : BaseActivity(), HomeInfoView {
    override fun setToolbar(): Toolbar {
        toolbar.title="Home"
        return toolbar
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_home
    }

    override val isHomeButtonEnabled: Boolean
        get() =false
    private lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homePresenter= HomePresenterImpl(this)
        homePresenter.getInfo()

    }

    override fun onInfoFetchSuccess(basicInfo: BasicInfo) {
//        Glide.with(iv_home_image)
//            .load(information.data.url)
//            .into(iv_home_image)
        tv_course_title.text=basicInfo.data.name
        tv_course_duration_value.text=basicInfo.data.class_duration
        tv_course_fee_value.text=basicInfo.data.fee
        tv_no_of_class_value.text=basicInfo.data.number_of_class.toString()
        val url=basicInfo.data.url
        tv_weburl_value.text=url
        tv_weburl_value.setOnClickListener {
            val intent=Intent(this, WebUrlActivity::class.java)

            intent.putExtra("website",url)
            startActivity(intent)
        }
        btn_registration.setOnClickListener {
             startActivity(Intent(this, LoginActivity::class.java))
            //showShortToast("upcoming.....")
        }
        val adapter= HomeAdapter(basicInfo.data.class_days)
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