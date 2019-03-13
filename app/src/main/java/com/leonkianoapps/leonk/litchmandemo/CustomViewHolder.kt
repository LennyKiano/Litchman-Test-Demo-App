package com.leonkianoapps.leonk.litchmandemo

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    //find the view here since the layout is passed here by the adapter

    val imageView = itemView.findViewById<ImageView>(R.id.event_item_imageView)!!
    val eventNameTextView = itemView.findViewById<TextView>(R.id.event_item_textView)!!
    val eventDescTextView = itemView.findViewById<TextView>(R.id.desc_item_textView)!!

    val layout = itemView.findViewById<LinearLayout>(R.id.recycler_main_layout_item)!!

}