package com.example.assignment_11.feature.student.presenter

import android.content.Context
import com.example.assignment_11.core.DataFetchCallBack
import com.example.assignment_11.feature.student.model.StudentModel
import com.example.assignment_11.feature.student.model.StudentModelImpl
import com.example.assignment_11.feature.student.model.StudentResponse
import com.example.assignment_11.feature.student.view.StudentsView

class StudentDetailsPresenterImpl(private val context: Context,private val id:Int,private val view: StudentsView):StudentDetailsPresenter {
    private val studentModel:StudentModel=StudentModelImpl(context)
    override fun getStudentDetails() {
        studentModel.getSingleStudent(id,object :DataFetchCallBack<StudentResponse>{
            override fun onSuccess(data: StudentResponse) {
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