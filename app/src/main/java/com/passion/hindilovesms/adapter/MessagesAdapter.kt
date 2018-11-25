package com.passion.hindilovesms.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.passion.hindilovesms.R
import com.passion.hindilovesms.SmsDetailActivity
import kotlinx.android.synthetic.main.layout_message_row.view.*
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast


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
            val clipboard = it.context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
            val clip = ClipData.newPlainText("label", lstMessages.get(position))
            clipboard!!.primaryClip = clip
            Toast.makeText(it.context, "Copied", Toast.LENGTH_LONG).show()
        }

        viewHolder.imgShare.setOnClickListener {
            val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, lstMessages.get(position))
            it.context.startActivity(Intent.createChooser(sharingIntent, "Share via"))
        }

        viewHolder.cvContainder.setOnClickListener {
            val intent = Intent(it.context, SmsDetailActivity::class.java)
            intent.putExtra("message", lstMessages.get(position))
            it.context.startActivity(intent)
        }


    }


    inner class MessagesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lblMessage = view.lblName
        val imgCopy = view.imgCopy
        val imgShare = view.imgShare
        val cvContainder = view.cvContainer
    }

}