package com.passion.hindilovesms.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.passion.hindilovesms.R
import kotlinx.android.synthetic.main.layout_message_row.view.*

class MessagesAdapter(var messages: List<String>) : RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>() {


    var lstMessages: List<String> = messages

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MessagesViewHolder {
        return MessagesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_message_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = lstMessages.size

    override fun onBindViewHolder(viewHolder: MessagesViewHolder, position: Int) {

        viewHolder.lblMessage.text = lstMessages.get(position)

        viewHolder.imgCopy.setOnClickListener {

        }

        viewHolder.imgShare.setOnClickListener {

        }

    }


    inner class MessagesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lblMessage = view.lblName
        val imgCopy = view.imgCopy
        val imgShare = view.imgShare
    }

}