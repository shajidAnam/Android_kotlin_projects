package com.example.assignment_11.feature.student.model

data class StudentResponse(
    val data: List<Data>,
    val message: String,
    val status: Boolean
)