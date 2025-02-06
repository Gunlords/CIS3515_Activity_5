package edu.temple.inclassuiacvitivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class TextSizeAdapter(private val context: Context, private val textSizes: List<Int>) : BaseAdapter() {

    override fun getCount(): Int = textSizes.size

    override fun getItem(position: Int): Any = textSizes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Display selected item with a fixed text size of 22sp
        val textView = (convertView as? TextView) ?: TextView(context)
        textView.text = textSizes[position].toString()
        textView.textSize = 22f // Fixed size for selected item
        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Display each item in the dropdown with its respective text size
        val textView = (convertView as? TextView) ?: TextView(context)
        textView.text = textSizes[position].toString()
        textView.textSize = textSizes[position].toFloat() // Varying sizes in dropdown
        return textView
    }
}
