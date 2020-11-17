package com.example.assignment_11.feature.student.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_11.R
import com.example.assignment_11.core.BaseActivity
import com.example.assignment_11.core.OnClickListener
import com.example.assignment_11.feature.student.model.Data
import com.example.assignment_11.feature.student.model.StudentResponse
import com.example.assignment_11.feature.student.model.StudentsAdapter
import com.example.assignment_11.feature.student.presenter.StudentsPresenter
import com.example.assignment_11.feature.student.presenter.StudentsPresenterImpl
import com.example.assignment_11.shared_preference.SharedPreference
import com.example.assignment_11.shared_preference.SharedPreferenceImpl
import kotlinx.android.synthetic.main.activity_student_list.*
import kotlinx.android.synthetic.main.toolbar.*

class StudentListActivity : BaseActivity(),StudentsView {
    override fun setToolbar(): Toolbar {
        toolbar.title="Student List"
        return toolbar
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_student_list
    }

    override val isHomeButtonEnabled: Boolean
        get() = true
    //private val sharedPreference:SharedPreference=SharedPreferenceImpl(this)
    private lateinit var studentsPresenter: StudentsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentsPresenter=StudentsPresenterImpl(this,this)
        studentsPresenter.getStudentList()
    }

    override fun onDataFetchSuccess(studentResponse: StudentResponse) {
        initAdapter(studentResponse.data)
    }

    private fun initAdapter(studentResponse: List<Data>) {
        val adapter=StudentsAdapter(studentResponse,object :OnClickListener{
            override fun onItemClickListener(position: Int) {
                val id=studentResponse[position].id
                val intent=Intent(this@StudentListActivity, Student_details_activity::class.java)
                intent.putExtra("ID",id)
                startActivity(intent)
            }

        })
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=adapter
    }


    override fun onDataFetchError(errorMessage: String) {
        showShortToast(errorMessage)
    }
}