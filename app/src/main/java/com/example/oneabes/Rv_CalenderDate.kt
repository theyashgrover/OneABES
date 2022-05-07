package com.example.oneabes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class Rv_CalenderDate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_calender_date)

        val myDatasetforLectureRV = DataSource().loadLectures()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = LectureAdapter(this , myDatasetforLectureRV)
        recyclerView.setHasFixedSize(true)
    }
}