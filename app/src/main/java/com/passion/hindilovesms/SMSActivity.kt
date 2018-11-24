package com.passion.hindilovesms

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.passion.hindilovesms.adapter.MessagesAdapter
import com.passion.hindilovesms.locallyhelper.MyDatabase
import kotlinx.android.synthetic.main.activity_sms.*

class SMSActivity : AppCompatActivity() {
    private lateinit var myDatabase: MyDatabase
    private lateinit var messages: List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)
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
        lstMessages.adapter = MessagesAdapter(messages)
    }
}
