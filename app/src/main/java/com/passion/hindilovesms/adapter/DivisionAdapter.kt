package com.passion.hindilovesms.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.passion.hindilovesms.CategoryActivity
import com.passion.hindilovesms.R
import com.passion.hindilovesms.SMSActivity
import com.passion.hindilovesms.YourSMSActivity
import com.passion.hindilovesms.model.Division
import kotlinx.android.synthetic.main.layout_divion_row.view.*

class DivisionAdapter(division: Array<Division>) : RecyclerView.Adapter<DivisionAdapter.DivisionViewHolder>() {
    var lstDivision: Array<Division> = division
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


            when (position) {
                0 -> {
                    val intent = Intent(it.context, YourSMSActivity::class.java)
                    it.context.startActivity(intent)
                }
                1, 2, 3 -> {
                    val intent = Intent(it.context, CategoryActivity::class.java)
                    intent.putExtra("position", position)
                    it.context.startActivity(intent)
                }
                4 -> {
                    val intent = Intent(it.context, SMSActivity::class.java)
                    intent.putExtra("position", position)
                    it.context.startActivity(intent)
                }
            }

        }
    }

    inner class DivisionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgIcon = view.imgIcon
        val lblName = view.lblName
        val cvContainer = view.cvContainer
    }

}