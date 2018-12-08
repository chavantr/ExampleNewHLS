package com.passion.hindilovesms.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.facebook.ads.Ad
import com.facebook.ads.AdChoicesView
import com.facebook.ads.NativeAd
import com.passion.hindilovesms.R
import com.passion.hindilovesms.SmsDetailActivity
import kotlinx.android.synthetic.main.item_native_ad.view.*
import kotlinx.android.synthetic.main.layout_message_row.view.*

class MessageAdForAdapter(messages: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var lstMesssages: List<Any> = messages


    override fun onCreateViewHolder(parent: ViewGroup, itemType: Int): RecyclerView.ViewHolder {
        return when (itemType) {
            MESSAGE -> MessagesViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.layout_message_row,
                    parent,
                    false
                )
            )
            NATIVE -> NativeAdViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_native_ad,
                    parent,
                    false
                )
            )
            else -> MessagesViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.layout_message_row,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = lstMesssages.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        val item = getItemViewType(position)

        if (item == MESSAGE) {

            var messageViewHolder = viewHolder as MessagesViewHolder

            var strMessage = lstMesssages[position] as String


            messageViewHolder.lblMessage.text = strMessage

            messageViewHolder.imgCopy.setOnClickListener {
                val clipboard = it.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText("label", strMessage)
                clipboard!!.primaryClip = clip
                Toast.makeText(it.context, "Copied", Toast.LENGTH_LONG).show()
            }

            messageViewHolder.imgShare.setOnClickListener {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, strMessage)
                it.context.startActivity(Intent.createChooser(sharingIntent, "Share via"))
            }

            messageViewHolder.cvContainer.setOnClickListener {
                val intent = Intent(it.context, SmsDetailActivity::class.java)
                intent.putExtra("message", strMessage)
                it.context.startActivity(intent)
            }


        } else if (item == NATIVE) {
            val nativeAdViewHolder = viewHolder as NativeAdViewHolder
            var nativeAd = lstMesssages.get(position) as NativeAd
            nativeAdViewHolder.tvAdTitle.text = nativeAd.advertiserName
            nativeAdViewHolder.tvAdBody.text = nativeAd.adBodyText
            nativeAdViewHolder.btnCTA.text = nativeAd.adCallToAction
            nativeAdViewHolder.sponsorLabel.text = nativeAd.sponsoredTranslation
            nativeAdViewHolder.adChoicesContainer.removeAllViews()
            val adChoicesView = AdChoicesView(nativeAdViewHolder.containder.context, nativeAd, true)
            nativeAdViewHolder.adChoicesContainer.addView(adChoicesView)
        }

    }


    override fun getItemViewType(position: Int): Int {
        val item = lstMesssages[position]
        return when (item) {
            is String -> MESSAGE
            is Ad -> NATIVE
            else -> -1
        }
    }

    inner class MessagesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lblMessage = view.lblName
        val imgCopy = view.imgCopy
        val imgShare = view.imgShare
        val cvContainer = view.cvContainer
    }

    inner class NativeAdViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val containder = view
        val adIconView = view.adIconView
        val tvAdTitle = view.tvAdTitle
        val tvAdBody = view.tvAdBody
        val btnCTA = view.btnCTA
        val adChoicesContainer = view.adChoicesContainer
        val mediaView = view.mediaView
        val sponsorLabel = view.sponsored_label
    }

    companion object {
        const val MESSAGE = 0
        const val NATIVE = 1
    }
}