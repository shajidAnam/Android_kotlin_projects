package com.example.assignment_11.feature.student.view

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.assignment_11.R
import com.example.assignment_11.core.BaseActivity
import com.example.assignment_11.feature.student.model.StudentResponse
import com.example.assignment_11.feature.student.presenter.StudentDetailsPresenter
import com.example.assignment_11.feature.student.presenter.StudentDetailsPresenterImpl
import kotlinx.android.synthetic.main.activity_student_details.*
import kotlinx.android.synthetic.main.toolbar.*


class Student_details_activity : BaseActivity(),StudentsView {
    override fun setToolbar(): Toolbar {
        toolbar.title="Student Details"
        return toolbar
    }

    override fun setLayoutId(): Int {
        return R.layout.activity_student_details
    }

    override val isHomeButtonEnabled: Boolean
        get() = true
        private lateinit var studentDetailsPresenter:StudentDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id:Int=intent.getIntExtra("ID", 0)
        studentDetailsPresenter=StudentDetailsPresenterImpl(this, id, this)
        studentDetailsPresenter.getStudentDetails()

    }

    override fun onDataFetchSuccess(studentResponse: StudentResponse) {
        val studentDetails=studentResponse.data[0]
        Glide.with(iv_studentDetailsImage)
            .load(studentDetails.image)
            .into(iv_studentDetailsImage)
        tv_StudentDetailsName.text=studentDetails.name
        tv_studentDetailsBioValue.text=studentDetails.biography
        tv_studentDetailsEmail.text=studentDetails.email
        tv_studentDetailsPhone.text=studentDetails.phone
        tv_studentDetailsInstitute.text=studentDetails.institution
        btn_copyBio.setOnClickListener {

            val manager: ClipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", tv_studentDetailsBioValue.getText())
            manager.setPrimaryClip(clipData)
            showShortToast("text coppied")
        }
    }

    override fun onDataFetchError(errorMessage: String) {
        showShortToast(errorMessage)
    }
}