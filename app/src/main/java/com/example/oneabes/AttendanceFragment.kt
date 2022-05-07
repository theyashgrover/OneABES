package com.example.oneabes

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.CalendarView.OnDateChangeListener
import android.widget.CalendarView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.oneabes.databinding.FragmentAttendanceBinding

class AttendanceFragment : Fragment() {
    private var binding: FragmentAttendanceBinding? = null
    var date: Long? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAttendanceBinding.inflate(inflater, container, false)
        val view: View = binding!!.root
        date = binding!!.cv.date
        binding!!.cv.setOnDateChangeListener { view, year, month, dayOfMonth ->
//            Toast.makeText(
//                context, "Year=$year Month=$month Day=$dayOfMonth", Toast.LENGTH_LONG
//            ).show()
            startActivity(Intent(activity,Rv_CalenderDate::class.java))
        }
        return view
    }
}