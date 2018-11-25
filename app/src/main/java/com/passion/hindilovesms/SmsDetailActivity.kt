package com.passion.hindilovesms

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sms_detail.*
import kotlinx.android.synthetic.main.content_sms_detail.*

class SmsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_detail)
        setSupportActionBar(toolbar)
        lblMessage.text = intent.extras.get("message").toString()

        title = "Love Messages"

        fab.setOnClickListener {

        }
    }
}
