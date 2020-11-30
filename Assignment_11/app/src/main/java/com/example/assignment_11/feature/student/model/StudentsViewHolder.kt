package com.example.assignment_11.feature.student.model

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_student_list.view.*

class StudentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val studentImage:AppCompatImageView=itemView.iv_studentImage
    val studentName:AppCompatTextView=itemView.tv_StudentName
    val studentEmail:AppCompatTextView=itemView.tv_studentEmail
    val studentInstitute:AppCompatTextView=itemView.tv_studentInstitute

}