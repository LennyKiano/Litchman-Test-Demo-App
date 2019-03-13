package com.leonkianoapps.leonk.litchmandemo

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

class RecyclerViewCustomAdapter(val dataList: ArrayList<Events>,val context: Context, val rootLayout: View) : RecyclerView.Adapter<CustomViewHolder>() {


    override fun onBindViewHolder(holder: CustomViewHolder, postion: Int) {

        val event: Events = dataList[postion]

        //using glide to load the images
        Glide.with(context).load(event.picture).into(holder.imageView)

        holder.eventNameTextView.text = event.event_name
        holder.eventDescTextView.text = event.event_desc

        holder.layout.setOnClickListener { it -> showEventSnack(postion)  }



    }

    private fun showEventSnack(position: Int) {

        val snackBar: Snackbar = Snackbar.make(rootLayout,"Event ${position+1} was tapped",Snackbar.LENGTH_LONG)
            .setAction("Okay", View.OnClickListener {  })

        snackBar.show()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        //inflate the recyclerView layout item here

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)


        return  CustomViewHolder(view)


    }

    override fun getItemCount(): Int {

        //return the size of the arrayList here

        return dataList.size
    }




}