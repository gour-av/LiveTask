package com.api_task.myapplication.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.api_task.myapplication.model.MessageItem
import kotlinx.android.synthetic.main.item_layout.view.*

class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setData(messageItem: MessageItem) {
        view.apply {

            tv_title.text = messageItem.title


        }
    }
}