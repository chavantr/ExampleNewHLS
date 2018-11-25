package com.passion.hindilovesms.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.passion.hindilovesms.R
import com.passion.hindilovesms.SMSActivity
import com.passion.hindilovesms.model.Category
import kotlinx.android.synthetic.main.layout_divion_row.view.*

class CategoryAdapter(division: List<Category>, category: Int) :
    RecyclerView.Adapter<CategoryAdapter.DivisionViewHolder>() {
    var lstDivision: List<Category> = division
    var mCategory: Int = category
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): DivisionViewHolder {
        return DivisionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_divion_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = lstDivision.size

    override fun onBindViewHolder(viewHolder: DivisionViewHolder, position: Int) {
        viewHolder.imgIcon.setImageResource(lstDivision.get(position).icon)
        viewHolder.lblName.text = lstDivision.get(position).name
        viewHolder.cvContainer.setOnClickListener {
            val intent = Intent(it.context, SMSActivity::class.java)
            intent.putExtra("mCat", lstDivision.get(position).name)
            intent.putExtra("catPosition", mCategory)
            intent.putExtra("position", position.plus(1))
            it.context.startActivity(intent)
        }
    }

    inner class DivisionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgIcon = view.imgIcon
        val lblName = view.lblName
        val cvContainer = view.cvContainer
    }

}