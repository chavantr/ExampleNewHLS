package com.passion.hindilovesms

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_your.*

class YourSMSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your)
        setSupportActionBar(toolbar)

        title = "आपके सन्देश"

        fab.setOnClickListener {
            val intent = Intent(this, AddYourSMSActivity::class.java)
            startActivity(intent)
        }
    }

}
