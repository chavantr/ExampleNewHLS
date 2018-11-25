package com.passion.hindilovesms

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.passion.hindilovesms.adapter.DivisionAdapter
import com.passion.hindilovesms.locallyhelper.MyDatabase
import com.passion.hindilovesms.model.Division
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    var division = arrayOf(
        Division(R.drawable.im5, "आपके सन्देश"),
        Division(R.drawable.im1, "विभाग"),
        Division(R.drawable.im2, "उत्सव"),
        Division(R.drawable.im4, "विशेष दिन"),
        Division(R.drawable.im3, "विनाक्रम")
    )

    private lateinit var myDatabase: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        title = "Love Messages"
        myDatabase = MyDatabase(this, "lovesms", null, 1)
        lstDivision.layoutManager = LinearLayoutManager(this)
        lstDivision.adapter = DivisionAdapter(division)
    }
}
