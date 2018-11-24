package com.passion.hindilovesms

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.passion.hindilovesms.adapter.CategoryAdapter
import com.passion.hindilovesms.model.Category
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        lstCategory.layoutManager = LinearLayoutManager(this)

        when (intent.extras.getInt("position")) {

            1 -> {
                lstCategory.adapter = CategoryAdapter(getLoveCategory(), 1)
            }
            2 -> {
                lstCategory.adapter = CategoryAdapter(getUtsavCategory(), 2)
            }
            3 -> {
                lstCategory.adapter = CategoryAdapter(getDailyCategory(), 3)
            }
        }
    }

    fun getLoveCategory(): List<Category> {
        var loveCategory = ArrayList<Category>()
        loveCategory.add(Category(R.drawable.v1, "शुभ प्रभात"));
        loveCategory.add(Category(R.drawable.v2, "शुभ रात्र"));
        loveCategory.add(Category(R.drawable.v3, "जीवन"));
        loveCategory.add(Category(R.drawable.v4, "प्रेम"));
        loveCategory.add(Category(R.drawable.v5, "जन्मदिन"));
        loveCategory.add(Category(R.drawable.v6, "मैत्री दिन"));
        loveCategory.add(Category(R.drawable.v7, "प्रजासत्ताक दिन"));
        loveCategory.add(Category(R.drawable.v8, "स्वतंत्रता दिवस"));
        loveCategory.add(Category(R.drawable.v9, "शादी की वर्षंगांठ"));
        loveCategory.add(Category(R.drawable.v10, "दिल टूटना"));
        loveCategory.add(Category(R.drawable.v11, "भूल न जाना"));
        loveCategory.add(Category(R.drawable.v12, "प्रेरणादायी"));
        loveCategory.add(Category(R.drawable.v13, "मित्रता"));
        loveCategory.add(Category(R.drawable.v14, "याद"));
        loveCategory.add(Category(R.drawable.v15, "जुदाई"));
        loveCategory.add(Category(R.drawable.v16, "माता-पिता"));
        loveCategory.add(Category(R.drawable.v17, "मोहब्बत"));
        loveCategory.add(Category(R.drawable.v18, "नया साल"));
        loveCategory.add(Category(R.drawable.v19, "बेवफा"));
        loveCategory.add(Category(R.drawable.v20, "मौसम"));
        loveCategory.add(Category(R.drawable.v21, "वास्तविक तथ्य"));
        loveCategory.add(Category(R.drawable.v22, "रूठना-मनाना"));
        loveCategory.add(Category(R.drawable.v23, "दुःखी"));
        loveCategory.add(Category(R.drawable.v24, "रोमांचक"));
        loveCategory.add(Category(R.drawable.v25, "मनोवृत्ती"));
        loveCategory.add(Category(R.drawable.v26, "क्षमा"));
        loveCategory.add(Category(R.drawable.v27, "वैचारिक"));
        loveCategory.add(Category(R.drawable.v28, "रिश्ते"));
        loveCategory.add(Category(R.drawable.v29, "आध्यात्मिक"));
        loveCategory.add(Category(R.drawable.v30, "पाठशाला"));
        loveCategory.add(Category(R.drawable.v31, "शुभ सप्ताह"));
        loveCategory.add(Category(R.drawable.v32, "चुटकुले"));
        loveCategory.add(Category(R.drawable.v33, "रोमांटिक शायरी"));
        loveCategory.add(Category(R.drawable.v34, "सॅड शायरी"));
        loveCategory.add(Category(R.drawable.v35, "सॉरी शायरी"));
        loveCategory.add(Category(R.drawable.v36, "दोस्ती शायरी"));
        loveCategory.add(Category(R.drawable.v37, "जन्मदिवस शायरी"));
        return loveCategory
    }

    fun getUtsavCategory(): List<Category> {
        var loveCategory = ArrayList<Category>()
        loveCategory.add(Category(R.drawable.icon1, "मकर संक्रांत"));
        loveCategory.add(Category(R.drawable.icon2, "महाशिवरात्रि"));
        loveCategory.add(Category(R.drawable.icon3, "नागपंचमी"));
        loveCategory.add(Category(R.drawable.icon4, "होली"));
        loveCategory.add(Category(R.drawable.icon5, "गुरुपौर्णिमा"));
        loveCategory.add(Category(R.drawable.icon6, "रक्षाबंधन"));
        loveCategory.add(Category(R.drawable.icon7, "जन्माष्टमी"));
        loveCategory.add(Category(R.drawable.icon8, "गणेश चतुर्थी"));
        loveCategory.add(Category(R.drawable.icon9, "नवरात्री"));
        loveCategory.add(Category(R.drawable.icon10, "दशहरा"));
        loveCategory.add(Category(R.drawable.icon11, "दिवाली"));
        loveCategory.add(Category(R.drawable.icon12, "ख्रिसमस/गुड फ्राइडे"));
        loveCategory.add(Category(R.drawable.u13, "अक्षय तृतिया"));
        loveCategory.add(Category(R.drawable.u14, "आंबेडकर जयंती"));
        loveCategory.add(Category(R.drawable.u15, "हनुमान जयंती"));
        loveCategory.add(Category(R.drawable.u16, "राम नवमी"));
        loveCategory.add(Category(R.drawable.u17, "रमजान ईद"));
        loveCategory.add(Category(R.drawable.u18, "करवा चौथ"));
        loveCategory.add(Category(R.drawable.u19, "बैसाखी"));
        loveCategory.add(Category(R.drawable.u20, "गांधी जयंती"));
        loveCategory.add(Category(R.drawable.u21, "तीज"));
        loveCategory.add(Category(R.drawable.u22, "दुर्गा पूजा"));
        loveCategory.add(Category(R.drawable.u23, "धनतेरस"));
        loveCategory.add(Category(R.drawable.u24, "बुद्ध पूर्णिमा"));
        loveCategory.add(Category(R.drawable.u25, "लोहड़ी"));
        loveCategory.add(Category(R.drawable.u26, "विश्वकर्मा पूजा"));
        return loveCategory
    }


    fun getDailyCategory(): List<Category> {
        var loveCategory = ArrayList<Category>()

        loveCategory.add(Category(R.drawable.d1, "मातृ दिवस"));
        loveCategory.add(Category(R.drawable.d2, "पिता दिवस"));
        loveCategory.add(Category(R.drawable.d3, "महिला दिवस"));
        loveCategory.add(Category(R.drawable.d4, "रोज डे"));
        loveCategory.add(Category(R.drawable.d5, "प्रोपोज़ डे"));
        loveCategory.add(Category(R.drawable.d6, "चॉकलेट डे"));
        loveCategory.add(Category(R.drawable.d7, "टेडी डे"));
        loveCategory.add(Category(R.drawable.d8, "प्रॉमिस डे"));
        loveCategory.add(Category(R.drawable.d9, "किस डे"));
        loveCategory.add(Category(R.drawable.d10, "हग डे"));
        loveCategory.add(Category(R.drawable.d11, "वैलेंटाइन्स डे"));
        loveCategory.add(Category(R.drawable.d12, "शिक्षक दिवस"));
        loveCategory.add(Category(R.drawable.d13, "मित्रता दिवस"));

        return loveCategory
    }


}
