package com.example.assignment_11.feature.student.model

import com.example.assignment_11.core.DataFetchCallBack

interface StudentModel {
    fun getStudentList(callBack: DataFetchCallBack<StudentResponse>)
    fun getSingleStudent(id:Int,callBack: DataFetchCallBack<StudentResponse>)
}