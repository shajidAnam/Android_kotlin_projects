package com.example.assignment_11.view.home

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_day.view.*

class HomeViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val courseDay:AppCompatTextView=itemView.tv_course_day
}