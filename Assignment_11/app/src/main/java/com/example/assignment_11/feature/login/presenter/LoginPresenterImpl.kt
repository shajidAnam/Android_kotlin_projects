package com.example.assignment_11.feature.login.presenter

import android.content.Context
import com.example.assignment_11.core.DataFetchCallBack
import com.example.assignment_11.feature.login.model.LoginModel
import com.example.assignment_11.feature.login.model.LoginModelImpl
import com.example.assignment_11.feature.login.model.LoginResponse
import com.example.assignment_11.feature.login.model.UserCredential
import com.example.assignment_11.feature.login.view.LoginView

class LoginPresenterImpl(private val userCredential: UserCredential,private val view:LoginView, private val context: Context):LoginPresenter {
    private val loginModel:LoginModel=LoginModelImpl(context)
    override fun login() {
        loginModel.login(userCredential,object :DataFetchCallBack<LoginResponse>{
            override fun onSuccess(data: LoginResponse) {
                view.onDataFetchSuccess(data)
            }

            override fun onError(throwable: Throwable) {
                if (throwable.localizedMessage!=null)
                view.onDataFetchError(throwable.localizedMessage)
                else
                    view.onDataFetchError("something went wrong")
            }

        })
    }
}