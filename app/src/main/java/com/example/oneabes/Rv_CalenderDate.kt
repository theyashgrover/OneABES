package com.example.oneabes

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_rv_calender_date.*
import kotlinx.android.synthetic.main.dialog_custom_back_confirmation.*
import kotlinx.android.synthetic.main.list_item.view.*

class Rv_CalenderDate : AppCompatActivity() {

    private var adapter:LectureAdapter? = null
    private var presentCounter : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_calender_date)

        val myDatasetforLectureRV = DataSource().loadLectures()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = LectureAdapter(this , myDatasetforLectureRV)
        recyclerView.setHasFixedSize(true)



        adapter = LectureAdapter(this , myDatasetforLectureRV)
        adapter!!.onItemClickListener = object : LectureAdapter.OnItemClickListener{
            override fun onClick(position: Int) {
                Toast.makeText(this@Rv_CalenderDate , "Lecture $position" , Toast.LENGTH_LONG).show()
                presentCounter++
            }
        }
        //toolbar
        setSupportActionBar(toolbar_lecture_activity)
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
        toolbar_lecture_activity.setNavigationOnClickListener {
           onBackPressed()
        }

        //onClickListeners
        buttonSubmitToday.setOnClickListener {
            customDialogForSubmitButton()
        }

    }
    private fun customDialogForSubmitButton(){
        val customDialog = Dialog(this)

        customDialog.setContentView(R.layout.dialog_custom_back_confirmation2)
        customDialog.tvYes.setOnClickListener {
            Toast.makeText(this,"Attendance marked for this lecture" ,Toast.LENGTH_SHORT).show()
            val intent = Intent(this , ResultActivity::class.java)
            startActivity(intent)
            customDialog.dismiss()
        }
        customDialog.tvNo.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun calculateAttendance() {
        var sumAttendanceYet: Int = 0
        var sumLecturesYet:Int  = 0
        var lecturesToday = presentCounter
        val totalLectures = 8 //TODO : Implement the call to show lectures selected by user
        //to share :
        val attendanceToday = (lecturesToday / totalLectures) * 100
        val attendanceYet: ArrayList<Int> = listOf<Int>() as ArrayList<Int>
        for (i in attendanceYet)
            attendanceYet.add(attendanceToday)

        val lecturesYet : ArrayList<Int> = listOf<Int>() as ArrayList<Int>

        for (i in lecturesYet)
            lecturesYet.add(8)

        for (i in attendanceYet)
            sumAttendanceYet += attendanceYet[i]

        for (i in lecturesYet)
            sumLecturesYet += lecturesYet[i]
    }
}