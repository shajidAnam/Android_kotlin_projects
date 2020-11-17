package com.example.assignment_11.feature.login.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.assignment_11.R
import com.example.assignment_11.core.BaseActivity
import com.example.assignment_11.feature.login.model.LoginResponse
import com.example.assignment_11.feature.login.model.UserCredential
import com.example.assignment_11.feature.login.presenter.LoginPresenter
import com.example.assignment_11.feature.login.presenter.LoginPresenterImpl
import com.example.assignment_11.feature.student.view.StudentListActivity
import com.example.assignment_11.shared_preference.SharedPreference
import com.example.assignment_11.shared_preference.SharedPreferenceImpl
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar.*

class LoginActivity : BaseActivity(),LoginView{
    lateinit var sharedPreference:SharedPreference
    override fun setToolbar(): Toolbar {
        toolbar.title="Login"
        return toolbar
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_login
    }

    override val isHomeButtonEnabled: Boolean
        get() = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         sharedPreference=SharedPreferenceImpl(this)
        btn_login.setOnClickListener {
            val userName=et_username.text.toString()
            val password=et_password.text.toString()
            val userCredential =UserCredential(userName,password)
            val  loginPresenter:LoginPresenter=LoginPresenterImpl(userCredential,this,this)
            loginPresenter.login()
        }
    }

    override fun onDataFetchSuccess(loginResponse: LoginResponse) {
        //val loginStatus: Boolean = sharedPreference.getBoolean(SharedPreference.LOGIN_STATUS)!!
        if (loginResponse.status){
            showShortToast(loginResponse.message)
            val intent = Intent(this,StudentListActivity::class.java)
            startActivity(intent)
        }
        else
            showShortToast(loginResponse.message)
        //showShortToast("login success")
    }

    override fun onDataFetchError(errorMessage: String) {
        showShortToast(errorMessage)
    }
}