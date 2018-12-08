package com.passion.hindilovesms

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import kotlinx.android.synthetic.main.activity_sms_detail.*
import kotlinx.android.synthetic.main.content_sms_detail.*

class SmsDetailActivity : AppCompatActivity() {

    private var adView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_detail)
        setSupportActionBar(toolbar)
        lblMessage.text = intent.extras.get("message").toString()

        title = "Love Messages"

        adView = AdView(this, "300409060814595_301007407421427", AdSize.BANNER_HEIGHT_50)

        banner_container.addView(adView)

        adView!!.loadAd()

        fab.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, intent.extras.get("message").toString())
            it.context.startActivity(Intent.createChooser(sharingIntent, "Share via"))

        }
    }
}
