package com.api_task.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.api_task.myapplication.R
import com.api_task.myapplication.model.MessageItem
import com.api_task.myapplication.viewholder.ViewHolder

class RecyclerAdapter(private var dataModelList: List<MessageItem>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataModelList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }
    fun updateList(modelList: List<MessageItem>) {
        dataModelList = modelList
        notifyDataSetChanged()
    }
}