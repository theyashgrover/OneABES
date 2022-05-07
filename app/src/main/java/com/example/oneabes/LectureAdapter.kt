package com.example.oneabes

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dialog_custom_back_confirmation.*
import kotlinx.android.synthetic.main.list_item.view.*



class LectureAdapter(private val context: Context , private val dataset: List<DailyLecture> )
    : RecyclerView.Adapter<LectureAdapter.ItemViewHolder>() {

    var onItemClickListener : OnItemClickListener? = null



    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.LectureNo)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureAdapter.ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: LectureAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.lecturesToday)

        if(holder is ItemViewHolder){
            holder.itemView.setOnClickListener {
                customDialogForSubmitButton(holder.itemView.context , holder)
            }
        }
    }


     fun customDialogForSubmitButton(context: Context ,holder: LectureAdapter.ItemViewHolder ){
        val customDialog = Dialog(context)

        customDialog.setContentView(R.layout.dialog_custom_back_confirmation)
        customDialog.tvYes.setOnClickListener {
            Toast.makeText(context,"Attendance marked for this lecture" ,Toast.LENGTH_SHORT).show()
            holder.itemView.iv_selected_color.visibility = View.VISIBLE
//            presentCounterr++
//            calculateAttendance(presentCounterr)
            customDialog.dismiss()
        }
        customDialog.tvNo.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }
    private fun calculateAttendance(presentCounterz : Int) {
        var sumAttendanceYet: Int = 0
        var sumLecturesYet:Int  = 0
        var lecturesToday = presentCounterz
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
        val totalAttendanceYet = (sumAttendanceYet/sumLecturesYet)*100
        val intent = Intent(context , Rv_CalenderDate::class.java)
        intent.putExtra("totalAttendanceYet" , totalAttendanceYet)
        intent.putExtra("attendanceToday" , attendanceToday)
        context.startActivity(intent)
        Toast.makeText(context , "Attendance Updated" , Toast.LENGTH_SHORT).show()
    }



    override fun getItemCount(): Int {
        return dataset.size
    }
    interface OnItemClickListener{
        fun onClick(position: Int)
    }
}