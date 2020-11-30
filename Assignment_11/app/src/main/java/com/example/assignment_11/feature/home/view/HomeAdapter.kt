package com.example.assignment_11.feature.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_11.R

class HomeAdapter(private val classDays:List<String>):RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_day,parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val classDay=classDays[position]
        holder.courseDay.text=classDay
    }

    override fun getItemCount(): Int {
       return classDays.size
    }
}