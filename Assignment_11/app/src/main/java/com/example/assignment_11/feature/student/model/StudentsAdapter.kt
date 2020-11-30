package com.example.assignment_11.feature.student.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment_11.R
import com.example.assignment_11.core.OnClickListener

class StudentsAdapter(private val studentList:List<Data>,private val itemClickListener:OnClickListener):RecyclerView.Adapter<StudentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_student_list,parent,false)
        return StudentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        val student=studentList[position]
        holder.studentName.text=student.name
        holder.studentEmail.text=student.email
        holder.studentInstitute.text=student.institution
        Glide.with(holder.studentImage)
            .load(student.image)
            .into(holder.studentImage)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}