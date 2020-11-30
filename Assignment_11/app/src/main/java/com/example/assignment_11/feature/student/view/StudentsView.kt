package com.example.assignment_11.feature.student.view

import com.example.assignment_11.feature.student.model.StudentResponse

interface StudentsView {
    fun onDataFetchSuccess(studentResponse:StudentResponse)
    fun onDataFetchError(errorMessage:String)
}