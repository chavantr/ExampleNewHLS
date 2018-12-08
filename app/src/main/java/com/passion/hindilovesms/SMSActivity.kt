package com.passion.hindilovesms

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.NativeAd
import com.facebook.ads.NativeAdListener
import com.passion.hindilovesms.adapter.MessageAdForAdapter
import com.passion.hindilovesms.adapter.MessagesAdapter
import com.passion.hindilovesms.locallyhelper.MyDatabase
import kotlinx.android.synthetic.main.activity_sms.*

class SMSActivity : AppCompatActivity() {
    private lateinit var myDatabase: MyDatabase
    private lateinit var messages: ArrayList<Any>
    private lateinit var messageAdForAdapter: MessageAdForAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        title = if (intent.hasExtra("mCat")) {
            intent.extras.get("mCat").toString()
        } else {
            "Love Messages"
        }


        myDatabase = MyDatabase(this, "lovesms", null, 1)
        lstMessages.layoutManager = LinearLayoutManager(this)
        if (intent.hasExtra("catPosition")) {
            val catPosition = intent.extras.getInt("catPosition")
            when (catPosition) {
                1 -> {
                    messages = myDatabase.getCategoryMessages(intent.extras.getInt("position"))
                }
                2 -> {
                    messages = myDatabase.getUtsavMessages(intent.extras.getInt("position"))
                }
                3 -> {
                    messages = myDatabase.getMessages(intent.extras.getInt("position"))
                }
            }
        } else {
            messages = myDatabase.unionMessages
        }
        // lstMessages.adapter = MessagesAdapter(messages)
        messageAdForAdapter = MessageAdForAdapter(messages)
        lstMessages.adapter = messageAdForAdapter


        val nativeAd = NativeAd(this, "300409060814595_300412187480949")

        nativeAd.setAdListener(adListener)

        nativeAd.loadAd()
    }


    private val adListener = object : NativeAdListener {

        override fun onAdClicked(p0: Ad?) {

        }

        override fun onMediaDownloaded(p0: Ad?) {

        }

        override fun onError(p0: Ad?, p1: AdError?) {

        }

        override fun onAdLoaded(ad: Ad?) {

            for (i in messages.indices) {
                if (i % 4 == 0 && i != 0) {
                    messages.add(i, ad!!)
                }
            }
            messageAdForAdapter.notifyDataSetChanged()
        }

        override fun onLoggingImpression(p0: Ad?) {

        }

    }
}
