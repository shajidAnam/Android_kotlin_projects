package com.example.assignment_11.feature.home.model

import java.io.Serializable

data class BasicInfo(
        val status: Boolean,
        val message: String,
        val data: Data

) : Serializable {
    data class Data(
            val class_days: List<String>,
            val name: String,
            val duration: String,
            val number_of_class: Int,
            val class_duration: String,
            val fee: String,
            val url: String
    )

}