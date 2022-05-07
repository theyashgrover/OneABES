package com.example.oneabes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        tvEnd.text = "Your Today's Attendance is 75% \n Your total attendance including all days yet is 75% \n No. of Lectures you need to attend for completion = 'Updated Soon'"
        btnFinish.setOnClickListener {
            startActivity(Intent(this , MainActivity::class.java))
        }
    }
}