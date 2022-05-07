package com.example.oneabes

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LectureAdapter(private val context: Context , private val dataset: List<DailyLecture>)
    : RecyclerView.Adapter<LectureAdapter.ItemViewHolder>(){

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
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}